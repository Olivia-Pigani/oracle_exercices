package org.example.ms_customer;


import jakarta.persistence.Id;

public class Customer {

    @Id
    private long id;

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String email;



}
