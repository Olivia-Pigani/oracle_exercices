package org.me.bank;

public class BankAccount {

    private static BankAccount bankAccountInstance;

    private double balance;

    private static final Object lock = new Object();

    private BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public static BankAccount getInstance(double initialBalance) {
        synchronized (BankAccount.class) {
            if (bankAccountInstance == null) {
                return bankAccountInstance = new BankAccount(initialBalance);
            }
        }
        return bankAccountInstance;
    }

    public double withdraw(double moneyToRemove) {
        synchronized (lock) {
            if (moneyToRemove <= balance) {
                return balance -= moneyToRemove;
            }
            return balance;
        }
    }

    public double deposit(double moneyToAdd) {
        return balance += moneyToAdd;
    }

    public String getBalance(){
        return "solde actuel: " + balance;
    }

}



