package org.me.bank;

public class MyBankAccount {

    private static volatile MyBankAccount myBankAccountInstance;
    private double balance;

    private MyBankAccount(double balance) {
        this.balance = balance;
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

    public synchronized void withdrawal(double amount) {
        if (amount<=balance){
            balance -= amount;
        }
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }
}