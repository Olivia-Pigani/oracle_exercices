package org.example;

import org.example.model.ICharacter;
import org.example.model.model_impl.HeroImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static org.example.CharacterDataHandler.*;


public class HMI {

    private static final Scanner scanner = new Scanner(System.in);
    private static AtomicInteger choice = new AtomicInteger();
    private static List<ICharacter> characterList = new ArrayList<>();


    public static void startGameMenu() {

        System.out.println("""
                ---Welcome in the game---
                1-make a new character
                2-load an already existing character
                3-quit the game
                choose an option :
                """);

        int userChoice = scanner.nextInt();
        scanner.nextLine();
        choice.set(userChoice);

        switch (choice.get()) {
            case 1 -> makeNewCharacterMenu();
            case 2 -> pickAnALreadyExistingHeroRandomlyMenu();
            case 3 -> {
                System.out.println("see you next time !");
                System.exit(0);
            }
        }

    }

    private static void pickAnALreadyExistingHeroRandomlyMenu() {
        pickRandomHero();
//        startEvents();
    }

    private static void makeNewCharacterMenu() {

        System.out.println("What is the name ?");
        String name = scanner.nextLine();

        System.out.println("What is the strength 1-100?");
        int strength = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is the health 1-100?");
        int health = scanner.nextInt();
        scanner.nextLine();

        HeroImpl newHero = new HeroImpl(name, strength, health);
        characterList.add(newHero);
        System.out.println("actual list of characters : " + characterList);
        characterUpload(newHero);

        startEvents(newHero);

        startGameMenu();
    }


}
