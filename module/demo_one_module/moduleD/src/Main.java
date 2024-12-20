import enterprise.Employee;
import enterprise.inventory.Pen;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1,"Alice"));
        employeeList.add(new Employee(2,"Bob"));

        Pen pen = new Pen(1,"blue");

        System.out.println(employeeList);
        System.out.println(pen);

    }
}