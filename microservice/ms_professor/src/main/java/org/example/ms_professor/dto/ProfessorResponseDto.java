package org.example.ms_professor.dto;

public record ProfessorResponseDto(

        long id,

        String firstName,

        String lastName,

        String birthDate,

        int subjectId

) {
}
