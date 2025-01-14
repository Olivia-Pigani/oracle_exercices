package org.example.ms_class.dto;

public record StudentResponseDto(
        long id,

        String firstName,

        String lastName,

        String birthDate
) {
}
