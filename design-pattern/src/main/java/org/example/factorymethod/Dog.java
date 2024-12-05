package org.example.factorymethod;

public class Dog implements Animal{
    @Override
    public void makeSound() {
        System.out.println("i am a dog and i eat bones");
    }

    @Override
    public void eat() {
        System.out.println("waf");
    }
}
