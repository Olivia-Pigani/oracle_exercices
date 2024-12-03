package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Set<LibraryItem> libraryItemSet = new HashSet<>();

    public static void main(String[] args) {

        printMenu();
    }

    private static void printMenu(){
        System.out.println(
                """
                        Welcome ! 
                        1. Add item to Library
                        2. See items list
                        """
        );


        int choice = scanner.nextInt();

        switch (choice){
            case 1 -> addItem();
            case 2 -> seeAllItems();
            case 3 -> quitProgram();
        }
    }


    private static void addItem(){

        var chariot = scanner.nextLine();
        String type = "";

        while(!type.equals("magazine") && !type.equals("book")){

            System.out.println("what is the type : Magazine or Book ?");

            type = scanner.nextLine().toLowerCase();

        }


        System.out.println("what is the title ?");

        var title = scanner.nextLine();

        System.out.println("what is the publication year ?");

        var publicationYear = scanner.nextInt();


        if (type.equals("book")){

            var chariot2 = scanner.nextLine();

            System.out.println("what is the genre ?");
            var genre = scanner.nextLine();

            System.out.println("what is the author ?");
            var author = scanner.nextLine();

            Book newBook = new Book(title,publicationYear, author, genre);

            libraryItemSet.add(newBook);

            printMenu();

        } else {

            Magazine newMagazine = new Magazine(title, publicationYear);
            libraryItemSet.add(newMagazine);

            printMenu();
        }



    }

    private static void seeAllItems(){

        System.out.println("All library items :");

        libraryItemSet.forEach(item -> System.out.println(item.getDetails()));

        printMenu();

    }
    private static void quitProgram(){

        System.out.println("bye");
        scanner.close();
        System.exit(0);

    }
}