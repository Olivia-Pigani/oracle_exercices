package org.example.composite;

import java.util.HashSet;
import java.util.Set;

public class Manager implements IEmployee {

    private String firstname;

    private String lastname;

    private String phoneNumber;

    Set<IEmployee> employeeSet = new HashSet<>();

    public Manager(String firstname, String lastname, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public void add(IEmployee employee){
        employeeSet.add(employee);
    }

    public void remove(IEmployee employee){
        employeeSet.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("manager " + firstname + " " + lastname + " with phone number : " + phoneNumber);
        System.out.println("he/she have those employee to manage : ");
        employeeSet.forEach(IEmployee::showDetails);
    }


}
