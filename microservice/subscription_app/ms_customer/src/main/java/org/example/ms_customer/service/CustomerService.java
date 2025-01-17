package org.example.ms_customer.service;

import org.example.ms_customer.entity.Customer;
import org.example.ms_customer.dto.CustomerRequestDto;
import org.example.ms_customer.dto.CustomerResponseDto;
import org.example.ms_customer.mapper.CustomerMapper;
import org.example.ms_customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto){
        //to update
        Optional<Customer> customerToFindInDatabase = customerRepository.getCustomersByEmail(customerRequestDto.email());

        if (customerToFindInDatabase.isPresent()){
            throw new RuntimeException("customer's email is already in database");
        }

        Customer newCustomer = CustomerMapper.toCustomer(customerRequestDto);

        customerRepository.save(newCustomer);

        return CustomerMapper.toCustomerResponseDto(newCustomer);

    }
}
