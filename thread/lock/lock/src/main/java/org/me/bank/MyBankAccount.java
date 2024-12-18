package org.me.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBankAccount {

    private static volatile MyBankAccount myBankAccountInstance;
    private double balance;
    private Lock lock;

    private MyBankAccount(double balance) {
        this.balance = balance;
        lock = new ReentrantLock();
    }

    public static MyBankAccount getInstance(double balance) {
        if (myBankAccountInstance == null) {
            synchronized (MyBankAccount.class) {
                if (myBankAccountInstance == null) {
                    myBankAccountInstance = new MyBankAccount(balance);
                }
            }
        }
        return myBankAccountInstance;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public void withdrawal(double amount) {
        lock.lock();
        try {
            if (amount<=balance){
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " a retiré "+ amount + " solde actuel : " + getBalance());
            } else {
                    System.out.println(Thread.currentThread().getName() + " n'a pas pu retirer "+ amount + " solde actuel : " + getBalance());

            }
        }finally {
            lock.unlock();
        }

    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " a déposé " + amount + " solde actuel : " + getBalance());
        }finally {
            lock.unlock();
        }
    }
}