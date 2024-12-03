package org.example;

public final class Mammal extends Animal {

    public Mammal(String name, String species) {
        super(name, species);
    }

    @Override
    void eat() {
        System.out.println("Mammals is eating");
    }

    @Override
    String getDetails() {
        return "mammal infos : " + this.getId() + " name: " + this.getName() + " species : " + this.getSpecies();
    }
}
