package org.me.bank;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyBankAccount myBankAccount = MyBankAccount.getInstance(500);

        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {

            for (int i = 0; i < 5; i++) {
                MyCallable callable = new MyCallable(100, true, myBankAccount);
                Future<Double> result = executor.submit(callable);
                System.out.println("Solde après retrait " + (i + 1) + ": " + result.get());
            }

            for (int i = 0; i < 5; i++) {
                MyCallable callable = new MyCallable(150, false, myBankAccount);
                Future<Double> result = executor.submit(callable);
                System.out.println("Solde après dépôt " + (i + 1) + ": " + result.get());
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}