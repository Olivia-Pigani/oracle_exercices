package org.example;

public abstract sealed class Animal permits Bird, Mammal {

    private static int idIncrementor = 0;

    private int id;

    private String name;

    private String species;

    public Animal(String name, String species) {
        id = idIncrementor++;
        this.name = name;
        this.species = species;
    }

    abstract void eat();

    abstract String getDetails();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

