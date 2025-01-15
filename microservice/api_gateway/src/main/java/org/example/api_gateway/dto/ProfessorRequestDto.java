package org.example.api_gateway.dto;

public record ProfessorRequestDto(
        String firstName,

        String lastName,

        String birthDate,

        int subjectId
) {
}
