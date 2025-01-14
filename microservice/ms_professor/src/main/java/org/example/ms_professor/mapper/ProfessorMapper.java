package org.example.ms_professor.mapper;

import org.example.ms_professor.dto.ProfessorRequestDto;
import org.example.ms_professor.dto.ProfessorResponseDto;
import org.example.ms_professor.entity.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorMapper {

    public static ProfessorResponseDto toProfessorResponseDto(Professor professor) {
        return new ProfessorResponseDto(
                professor.getId(),
                professor.getFirstName(),
                professor.getLastName(),
                professor.getBirthDate(),
                professor.getSubject()
        );
    }

    public static List<ProfessorResponseDto> toProfessorResponseDtoList(List<Professor> professorList) {
        return professorList.stream()
                .map(ProfessorMapper::toProfessorResponseDto)
                .toList();
    }

    public static Professor toProfessor(ProfessorRequestDto professorRequestDto) {
        return new Professor(
                professorRequestDto.firstName(),
                professorRequestDto.lastName(),
                professorRequestDto.birthDate(),
                professorRequestDto.subject()
        );
    }

    public static List<Professor> toProfessorList(List<ProfessorRequestDto> professorRequestDtoList) {
        return professorRequestDtoList.stream()
                .map(ProfessorMapper::toProfessor)
                .toList();
    }
}
