package org.example.ms_student.mapper;

import org.example.ms_student.dto.StudentRequestDto;
import org.example.ms_student.dto.StudentResponseDto;
import org.example.ms_student.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMapper {

    public static StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getBirthDate()
        );
    }

    public static List<StudentResponseDto> toStudentResponseDtoList(List<Student> studentList) {
        return studentList.stream()
                .map(StudentMapper::toStudentResponseDto)
                .toList();
    }

    public static Student toStudent(StudentRequestDto studentRequestDto) {
        return new Student(
                studentRequestDto.firstName(),
                studentRequestDto.lastName(),
                studentRequestDto.birthDate()
        );
    }

    public static List<Student> toStudentList(List<StudentRequestDto> studentRequestDto) {
        return studentRequestDto.stream()
                .map(StudentMapper::toStudent)
                .toList();
    }

}
