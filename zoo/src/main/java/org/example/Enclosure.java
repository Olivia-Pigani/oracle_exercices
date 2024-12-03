package org.example;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {

    private static int idIncrementor = 0;

    private int id;

    private String name;

    private List<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal){
        animalList.add(animal);
        System.out.println(animal.getName() + " has been added");
    }

    public void removeAnimal(Animal animal){
        animalList.remove(animal);
        System.out.println(animal.getName() + " has been removed");
    }

    public void listAllAnimals(){
        animalList.forEach(animal -> System.out.println(animal.getId() + " " + animal.getName()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
