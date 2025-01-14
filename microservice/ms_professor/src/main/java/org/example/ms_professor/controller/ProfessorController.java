package org.example.ms_professor.controller;

import org.example.ms_professor.dto.ProfessorRequestDto;
import org.example.ms_professor.dto.ProfessorResponseDto;
import org.example.ms_professor.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/professor")
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> getAllProfessors(){
        return new ResponseEntity<>(professorService.getAllProfessors(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> getProfessorById(@PathVariable("id") long id){
        return new ResponseEntity<>(professorService.getProfessorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postAProfessor(@RequestBody ProfessorRequestDto professorRequestDto){
        return new ResponseEntity<>(professorService.saveAProfessor(professorRequestDto),HttpStatus.CREATED);
    }

}
