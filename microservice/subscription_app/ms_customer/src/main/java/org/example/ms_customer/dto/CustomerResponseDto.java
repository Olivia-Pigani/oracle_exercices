package org.example.ms_customer.dto;

public record CustomerResponseDto(

        String id,

        String firstname,

        String lastname,

        String phoneNumber,

        String email
) {
}
