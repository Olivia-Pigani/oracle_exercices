package org.example.server;

import java.util.List;

public class EmployeeService {

    private final InMemoryDatabase database;


    public EmployeeService(InMemoryDatabase database) {
        this.database = database;
    }

    public List<Employee> getAllEmployees() {
        return database.getAllEmployees();
    }
}
