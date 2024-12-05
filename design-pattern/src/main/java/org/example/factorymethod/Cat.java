package org.example.factorymethod;

public class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("i am a cat and i eat fish");
    }

    @Override
    public void makeSound() {
        System.out.println("maow");
    }
}
