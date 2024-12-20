package org.example.server;

import java.util.Arrays;
import java.util.List;

public class InMemoryDatabase implements EmployeeRepository{

    List<Employee> employees = Arrays.asList(
            new Employee("bob"),
            new Employee("alice")
    );

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
