package org.example;

public class Person {

    private String name;

    private int age;

    public Person(){
        this.name="unknown";
        this.age=0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //private : we need to make it public => use reflexion !
    private void sayHello(){
        System.out.println("my name is " + name + " i have " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
