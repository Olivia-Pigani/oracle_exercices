package org.example.ms_customer.mapper;

import org.example.ms_customer.entity.Customer;
import org.example.ms_customer.dto.CustomerRequestDto;
import org.example.ms_customer.dto.CustomerResponseDto;

public class CustomerMapper {

    public static Customer toCustomer(CustomerRequestDto customerRequestDto){
        return new Customer(
                customerRequestDto.firstname(),
                customerRequestDto.lastname(),
                customerRequestDto.phoneNumber(),
                customerRequestDto.email()
        );
    }

    public static CustomerResponseDto toCustomerResponseDto(Customer customer){
        return new CustomerResponseDto(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getPhoneNumber(),
                customer.getEmail()
        );
    }
}
