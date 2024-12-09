package org.example;

import org.example.menu.ConsoleMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooManager implements IZooAction {

    private static ConsoleMenu consoleMenu = new ConsoleMenu();
    private static Scanner scanner = new Scanner(System.in);
    private static List<Enclosure> enclosureList = new ArrayList<>();
    public static void main(String[] args) {

         Enclosure enclosure1 = new Enclosure("myZoo");
         Enclosure enclosure2 = new Enclosure("myZoo2");
        enclosureList.add(enclosure1);
        enclosureList.add(enclosure2);

        consoleMenu.mainMenu();

    }

    private void startMenu(){
        int choice = scanner.nextInt();

        switch(choice){
            case 1 -> addAnimal();
            case 2 -> listAnimals();
            case 3 -> moveAnAnimal();
            case 4 -> feedAllAnimals();
            case 5 -> quitProgram();
        }
    }

    @Override
    public void performAction() {

    }

    public void feedAllAnimals() {



    }

    public void moveAnAnimal() {
        System.out.println("choose the animal id please");

        var animalId = scanner.nextInt();

        Animal chosenAnimal = enclosureList.stream()
                .flatMap(enclosure -> enclosure.getAnimalList().stream())
                .filter(animal -> animal.getId() == animalId)
                .findFirst()
                .orElse(null);

        if (chosenAnimal == null){
            System.out.println("there is no such animal sorry");
            consoleMenu.mainMenu();
        }
        
        //make it move
        
    }

    private static void listAnimals() {

        enclosureList.forEach(Enclosure::listAllAnimals);
        consoleMenu.mainMenu();
    }


    private static void addAnimal() {
        System.out.println("what is the name ?");

        var animalName = scanner.nextLine();

        System.out.println("what is the species ?");

        var animalSpecies = scanner.nextLine().toLowerCase();

        if(!animalSpecies.equals("bird") && !animalSpecies.equals("mammal")){
            System.out.println("there is no such species, try again");
            consoleMenu.mainMenu();
        }

        System.out.println("which enclosure ( tell it's id ) ?");

        var chosenEnclosure = scanner.nextInt();
        Enclosure enclosureExist = enclosureList.stream()
                .filter(e->e.getId() == chosenEnclosure)
                .findFirst()
                .orElse(null);

        if(enclosureExist == null){
            System.out.println("there is no such enclosure, sorry");
            consoleMenu.mainMenu();
        }

        if (animalSpecies.equals("bird")){
            Bird bird = new Bird(animalName,animalSpecies);
            enclosureExist.addAnimal(bird);
        } else {
            Mammal mammal = new Mammal(animalName,animalSpecies);
            enclosureExist.addAnimal(mammal);
        }

        consoleMenu.mainMenu();
    }



    private static void quitProgram() {
        System.out.println("bye");
        scanner.close();
        System.exit(0);
    }
}