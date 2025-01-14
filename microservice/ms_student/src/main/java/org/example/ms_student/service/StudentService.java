package org.example.ms_student.service;

import org.example.ms_student.dto.StudentRequestDto;
import org.example.ms_student.dto.StudentResponseDto;
import org.example.ms_student.entity.Student;
import org.example.ms_student.mapper.StudentMapper;
import org.example.ms_student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseDto> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return StudentMapper.toStudentResponseDtoList(studentList);
    }

    public String saveAStudent(StudentRequestDto studentRequestDto) {
        Student newStudent = StudentMapper.toStudent(studentRequestDto);
        Student addedStudent = studentRepository.save(newStudent);

        return "the new student " + addedStudent + " has been successfully added";
    }

    public StudentResponseDto getStudentById(long id) throws ClassNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(ClassNotFoundException::new);

        return StudentMapper.toStudentResponseDto(student);

    }
}
