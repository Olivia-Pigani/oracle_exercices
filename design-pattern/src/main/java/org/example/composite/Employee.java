package org.example.composite;

public class Employee implements IEmployee{

    private String firstname;

    private String lastname;

    private String phoneNumber;

    public Employee(String firstname, String lastname, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }


    @Override
    public void showDetails() {
        System.out.println(" employee " + firstname + " " + lastname + " have this phone number : " + phoneNumber);
    }
}
