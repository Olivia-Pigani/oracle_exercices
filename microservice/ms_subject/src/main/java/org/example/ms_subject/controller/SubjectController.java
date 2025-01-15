package org.example.ms_subject.controller;

import org.example.ms_subject.dto.SubjectRequestDto;
import org.example.ms_subject.dto.SubjectResponseDto;
import org.example.ms_subject.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public String saveASubject(SubjectRequestDto subjectRequestDto) {
        subjectService.saveSubject(subjectRequestDto);
        return "subject has been added";
    }

    @GetMapping
    public List<SubjectResponseDto> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
}
