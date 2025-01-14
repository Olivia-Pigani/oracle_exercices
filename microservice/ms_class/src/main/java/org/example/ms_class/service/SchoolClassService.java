package org.example.ms_class.service;

import org.example.ms_class.dto.ProfessorResponseDto;
import org.example.ms_class.dto.SchoolClassRequestDto;
import org.example.ms_class.dto.StudentResponseDto;
import org.example.ms_class.entity.SchoolClass;
import org.example.ms_class.repository.SchoolClassRepository;
import org.example.ms_class.util.RestClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.example.ms_class.constant.ApiConstant.*;

@Service
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;

    public SchoolClassService(SchoolClassRepository schoolClassRepository) {
        this.schoolClassRepository = schoolClassRepository;
    }

    public String saveAClass(@RequestBody SchoolClassRequestDto schoolClassRequestDto) {

        //check if professor and all students exists in other microservices
        RestClient<ProfessorResponseDto> professorRestClient = new RestClient<>(PROFESSOR_API_ROOT + schoolClassRequestDto.professorId());
        ProfessorResponseDto professor = professorRestClient.getRequest(ProfessorResponseDto.class);

        if (professor == null){
            return "the professor do not exists in database";
        }

        for (long studentId: schoolClassRequestDto.studentIdList()) {
            try {
                RestClient<StudentResponseDto> studentRestClient = new RestClient<>(STUDENT_API_ROOT + studentId);
            }catch (RuntimeException ex){
                System.out.println("all students are not not persisted in student microservice !");
            }

        }



        SchoolClass schoolClass = new SchoolClass(
                schoolClassRequestDto.professorId(),
                schoolClassRequestDto.studentIdList()
        );
        schoolClassRepository.save(schoolClass);
        return "the class has been successfully added";
    }


    public String getClassDetailsById(long id) {

        SchoolClass schoolClass = schoolClassRepository.findById(id).orElseThrow(()->new RuntimeException("there is no schoolclass with this id"));

        RestClient<ProfessorResponseDto> professorRestClient = new RestClient<>(PROFESSOR_API_ROOT + schoolClass.getProfessorId());
        ProfessorResponseDto professor = professorRestClient.getRequest(ProfessorResponseDto.class);

        if (professor == null){
            return "the professor do not exists in database";
        }

        List<StudentResponseDto> studentResponseDtoList = new ArrayList<>();
        for (long studentId: schoolClass.getStudentIdList()) {
            try {
                RestClient<StudentResponseDto> studentRestClient = new RestClient<>(STUDENT_API_ROOT + studentId);
                StudentResponseDto student = studentRestClient.getRequest(StudentResponseDto.class);
                studentResponseDtoList.add(student);
            }catch (RuntimeException ex){
                System.out.println("all students are not not persisted in student microservice !");
            }
        }

        return "the class has a professor : " + professor + " and have those students : " + studentResponseDtoList;
    }


}
