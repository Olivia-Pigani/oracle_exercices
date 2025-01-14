package org.example.ms_professor.dto;

public record ProfessorRequestDto(

        String firstName,

        String lastName,

        String birthDate,

        String subject
) {
}
