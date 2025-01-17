package org.example.ms_customer.dto;


public record CustomerRequestDto(

        String firstname,

        String lastname,

        String phoneNumber,

        String email
) {
}
