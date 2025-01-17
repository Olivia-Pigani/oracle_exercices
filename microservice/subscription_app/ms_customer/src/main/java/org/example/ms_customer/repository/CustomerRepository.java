package org.example.ms_customer.repository;

import org.example.ms_customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer,String> {

    Optional<Customer> getCustomersByEmail(String email);
}
