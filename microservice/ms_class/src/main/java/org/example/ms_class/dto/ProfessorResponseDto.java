package org.example.ms_class.dto;

public record ProfessorResponseDto(
        long id,

        String firstName,

        String lastName,

        String birthDate,

        String subject
) {
}
