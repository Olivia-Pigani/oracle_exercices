package org.example;

public final class Bird extends Animal{

    public Bird(String name, String species) {
        super(name, species);
    }

    @Override
    void eat() {
        System.out.println("Bird is eating");
    }

    @Override
    void getDetails() {
        return super.getDetails() + "bird infos : " + this.getId() + " name: " + this.getName() + " species : " + this.getSpecies();
    }
}
