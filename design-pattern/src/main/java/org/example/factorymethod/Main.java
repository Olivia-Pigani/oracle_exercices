package org.example.factorymethod;

public class Main {
    public static void main(String[] args) {
        AnimalFactory catFactory = new CatFactory();
        AnimalFactory dogFactory = new DogFactory();

        Animal cat = catFactory.createAnimal();
        Animal dog = dogFactory.createAnimal();

        cat.eat();
        cat.makeSound();

        dog.makeSound();
        dog.eat();
    }
}
