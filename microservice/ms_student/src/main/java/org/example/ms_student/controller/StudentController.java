package org.example.ms_student.controller;

import org.example.ms_student.dto.StudentRequestDto;
import org.example.ms_student.dto.StudentResponseDto;
import org.example.ms_student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable("id") long id) throws ClassNotFoundException {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postAStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return new ResponseEntity<>(studentService.saveAStudent(studentRequestDto), HttpStatus.CREATED);
    }

}
