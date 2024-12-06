package org.example.composite;

public class Main {
    public static void main(String[] args) {

        IEmployee employee1 = new Employee("bob", "wallace", "0624555555");
        IEmployee employee3 = new Employee("dwight", "schrut", "0624555555");
        IEmployee employee4 = new Employee("pam", "beesly", "0624555555");

        Manager manager = new Manager("michael", "scott", "0645454545");
        manager.add(employee1);
        manager.add(employee3);

        manager.showDetails();
    }
}
