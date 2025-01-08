package org.example;

import org.example.pojo.Activity;

import java.io.IOException;
import java.util.Scanner;

import static org.example.BinaryHandler.makeBackup;
import static org.example.BinaryHandler.readBackup;
import static org.example.TextHandler.addActivity;
import static org.example.TextHandler.getActivities;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static int menuChoice;
    private static String activities;

    public static void main(String[] args) throws IOException {

        printMenu();

    }

    public static void printMenu() throws IOException {
        System.out.println("""
                
                Hello, what do you want to do ? 
                1-add activity
                2-see activities
                3-make binary backup
                4-read binary backup
                5-quit the program
                
                """);


        menuChoice = scanner.nextInt();

        var chariot = scanner.nextLine();

        switch (menuChoice) {
            case 1 -> addActivityMenu();
            case 2 -> seeActivities();
            case 3 -> makeBackupMenu();
            case 4 -> readBackupMenu();
            case 5 -> {
                System.out.println("bye !");
                System.exit(0);
            }

        }

        printMenu();
    }

    private static void readBackupMenu() {

        readBackup();

    }

    private static void makeBackupMenu() throws IOException {

        makeBackup();

    }

    private static void seeActivities() throws IOException {

        activities = getActivities();

        System.out.println(activities);

        printMenu();

    }

    private static void addActivityMenu() throws IOException {

        System.out.println("what activity did you do ?");

        String activityDescription = scanner.nextLine();

        Activity newActivity = new Activity(activityDescription);

        addActivity(newActivity);

        printMenu();
    }

}