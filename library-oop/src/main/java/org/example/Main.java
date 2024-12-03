package org.example;

import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Set<LibraryItem> libraryItemSet = new HashSet<>();
    static Set<BorrowRecord> borrowRecordSet = new HashSet<>();

    public static void main(String[] args) {

        printMenu();
    }

    private static void printMenu(){
        System.out.println(
                """
                        Welcome ! 
                        1. Add item to Library
                        2. See items list
                        3.borrow a book
                        4.See all borrows
                        5.quit the program
                        """
        );


        int choice = scanner.nextInt();

        switch (choice){
            case 1 -> addItem();
            case 2 -> seeAllItems();
            case 3 -> borrowBook();
            case 4 -> seeAllBorrows();
            case 5 -> quitProgram();
        }
    }

    private static void seeAllBorrows() {

        borrowRecordSet.forEach(borrow -> System.out.println(borrow.toString()));

        printMenu();

    }

    private static void borrowBook() {
        System.out.println("which item you would like to borrow ?  Please tell the item id");

        int itemId = scanner.nextInt();

        var chariot = scanner.nextLine();

        System.out.println("what is your name ?");

        String borrowerName = scanner.nextLine();

        BorrowRecord newBorowRecord = new BorrowRecord(itemId,borrowerName, Instant.now().toString());

        borrowRecordSet.add(newBorowRecord);

        printMenu();

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