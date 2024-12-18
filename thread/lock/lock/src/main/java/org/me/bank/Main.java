package org.me.bank;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyBankAccount myBankAccount = MyBankAccount.getInstance(500);

        Thread deposit1 = new Thread(() -> myBankAccount.deposit(100));
        Thread withdraw1 = new Thread(() -> myBankAccount.withdrawal(600));
        Thread withdraw2 = new Thread(() -> myBankAccount.withdrawal(600));


        deposit1.start();
        withdraw1.start();
        withdraw2.start();

        try {
            deposit1.join();
            withdraw1.join();
            withdraw2.join();
        }catch (InterruptedException ex){
            System.out.println("interrupted");
        }

        System.out.println("program is over");

    }


}


