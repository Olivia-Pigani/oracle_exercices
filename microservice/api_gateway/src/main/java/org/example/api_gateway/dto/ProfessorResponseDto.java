package org.example.api_gateway.dto;

public record ProfessorResponseDto(
        long id,

        String firstName,

        String lastName,

        String birthDate,

        String subject
) {
}
