package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Calculator> allCalculatorFuncMap = new HashMap<>();

    public static void main(String[] args) {

        allCalculatorFuncMap.put("addition", (nb1, nb2) -> nb1 + nb2);
        allCalculatorFuncMap.put("substraction", (nb1, nb2) -> nb1 - nb2);
        allCalculatorFuncMap.put("multiply", (nb1, nb2) -> nb1 * nb2);
        allCalculatorFuncMap.put("divide", (nb1, nb2) -> nb1 / nb2);

        printMenu();

    }

    private static void printMenu() {
        Consumer<String> printMessage = m -> System.out.println(m);
        printMessage.accept("""
                
                Welcome to the calculator ! 
                1.addition
                2.substraction
                3.multiply
                4.divide
                5.quit program
                
                """);

        int choice = scanner.nextInt();

        var chariot = scanner.nextLine();

        switch (choice) {
            case 1 -> {
                printMessage.accept(" number 1 ? ");
                var nb1Add = scanner.nextDouble();
                printMessage.accept(" number 2 ? ");
                var nb2Add = scanner.nextDouble();

                Calculator addition = allCalculatorFuncMap.get("addition");
                double result = addition.addition(nb1Add, nb2Add);
                printMessage.accept(String.valueOf(result));

                printMenu();
            }

            case 2 -> {
                printMessage.accept(" number 1 ? ");
                var nb1Sub = scanner.nextDouble();
                printMessage.accept(" number 2 ? ");
                var nb2Sub = scanner.nextDouble();

                Calculator substraction = allCalculatorFuncMap.get("substraction");
                double result = substraction.addition(nb1Sub, nb2Sub);
                printMessage.accept(String.valueOf(result));

                printMenu();
            }

            case 3 -> {
                printMessage.accept(" number 1 ? ");
                var nb1Mul = scanner.nextDouble();
                printMessage.accept(" number 2 ? ");
                var nb2Mul = scanner.nextDouble();

                Calculator multiply = allCalculatorFuncMap.get("multiply");
                double result = multiply.addition(nb1Mul, nb2Mul);
                printMessage.accept(String.valueOf(result));

                printMenu();
            }

            case 4 -> {
                printMessage.accept(" number 1 ? ");
                var nb1Div = scanner.nextDouble();
                printMessage.accept(" number 2 ? ");
                var nb2Div = scanner.nextDouble();

                Calculator multiply = allCalculatorFuncMap.get("divide");
                double result = multiply.addition(nb1Div, nb2Div);
                printMessage.accept(String.valueOf(result));

                printMenu();
            }

            case 5 -> {
                printMessage.accept("bye");
                System.exit(0);
            }
        }

    }
}