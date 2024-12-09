package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Calculator<Double>> allCalculatorFuncMap = new HashMap<>();
    public static Consumer<String> printMessage = m -> System.out.println(m);

    public static void main(String[] args) {


        allCalculatorFuncMap.put("addition", (nb1, nb2) -> nb1 + nb2);
        allCalculatorFuncMap.put("substraction", (nb1, nb2) -> nb1 - nb2);
        allCalculatorFuncMap.put("multiply", (nb1, nb2) -> nb1 * nb2);
        allCalculatorFuncMap.put("divide", (nb1, nb2) -> nb1 / nb2);

        mainMenu();

    }

    private static void mainMenu(){
        printMessage.accept("""
                
                Welcome to the calculator ! 
                1.addition
                2.substraction
                3.multiply
                4.divide
                5.quit program
                
                """);

        int choice = scanner.nextInt();

        if (choice == 5){
            printMessage.accept("bye");
            System.exit(0);
        }

        var chariot = scanner.nextLine();

        printMessage.accept(" number 1 ? ");
        var nb1 = scanner.nextDouble();
        printMessage.accept(" number 2 ? ");
        var nb2 = scanner.nextDouble();

        if (nb1 < 1 || nb2 < 1){
            printMessage.accept("both number can not be below 0, start again please");
            mainMenu();
        } else {

            action(nb1,nb2,choice);
        }


    }

    private static void action(double nb1, double nb2, int choice) {

        switch (choice) {
            case 1 -> {
                Calculator addition = allCalculatorFuncMap.get("addition");
                Number result = addition.action(nb1, nb2);
                printMessage.accept(String.valueOf(result));

                mainMenu();
            }

            case 2 -> {

                Calculator substraction = allCalculatorFuncMap.get("substraction");
                Number result = substraction.action(nb1, nb2);
                printMessage.accept(String.valueOf(result));

                mainMenu();
            }

            case 3 -> {

                Calculator multiply = allCalculatorFuncMap.get("multiply");
                Number result = multiply.action(nb1, nb2);
                printMessage.accept(String.valueOf(result));

                mainMenu();
            }

            case 4 -> {

                Calculator multiply = allCalculatorFuncMap.get("divide");
                Number result = multiply.action(nb1, nb2);
                printMessage.accept(String.valueOf(result));

                mainMenu();
            }

        }

    }
}