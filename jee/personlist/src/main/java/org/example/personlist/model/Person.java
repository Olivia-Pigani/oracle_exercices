package org.example.personlist.model;

import java.time.LocalDate;

public class Person {

    private static long idIncrementor = 0L;

    private long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.id = ++idIncrementor;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
