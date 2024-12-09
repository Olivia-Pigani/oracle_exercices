package org.example.menu;

import java.util.Scanner;

public class ConsoleMenu {

    private static Scanner scanner = new Scanner(System.in);
    private static int choice;

    public void mainMenu(){


        System.out.println("""        
                === Menu Zoo ===
                1. add animal
                2.list animals
                3.move an animal
                4.feed animal
                5.quit program
                """
        );

        int choice = scanner.nextInt();

        switch(choice){
            case 1 -> addAnimalMenu();
            case 2 -> listAnimalsMenu();
            case 3 -> moveAnAnimalMenu();
            case 4 -> feedAllAnimalsMenu();
            case 5 -> quitProgramMenu();
        }

    }

    private void addAnimalMenu() {

    }


}
