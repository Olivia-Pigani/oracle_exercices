package org.example.ms_professor.service;

import org.example.ms_professor.dto.ProfessorRequestDto;
import org.example.ms_professor.dto.ProfessorResponseDto;
import org.example.ms_professor.entity.Professor;
import org.example.ms_professor.mapper.ProfessorMapper;
import org.example.ms_professor.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorResponseDto> getAllProfessors() {
        List<Professor> studentList = professorRepository.findAll();
        return ProfessorMapper.toProfessorResponseDtoList(studentList);
    }

    public String saveAProfessor(ProfessorRequestDto professorRequestDto) {
        Professor newProfessor = ProfessorMapper.toProfessor(professorRequestDto);
        Professor addedProfessor = professorRepository.save(newProfessor);

        return "the new professor " + addedProfessor + " has been successfully added";
    }

    public ProfessorResponseDto getProfessorById(long id) {
        Professor professor = professorRepository.findById(id).orElseThrow(ClassCastException::new);

        return ProfessorMapper.toProfessorResponseDto(professor);
    }
}
