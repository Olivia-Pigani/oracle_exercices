package org.example.ms_customer.controller;

import org.example.ms_customer.dto.CustomerRequestDto;
import org.example.ms_customer.dto.CustomerResponseDto;
import org.example.ms_customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> saveCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        return new ResponseEntity<>(customerService.saveCustomer(customerRequestDto), HttpStatus.CREATED);
    }
}
