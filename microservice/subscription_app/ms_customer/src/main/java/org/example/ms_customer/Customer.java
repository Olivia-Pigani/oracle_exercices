package org.example.ms_customer;


import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    private String id;

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String email;


}
