package org.me.bank;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Double> {

    private final double money;
    private final boolean isWithdrawal; // withdrawal is true, deposit is false
    private final MyBankAccount account;

    public MyCallable(double money, boolean isWithdrawal, MyBankAccount account) {
        this.money = money;
        this.isWithdrawal = isWithdrawal;
        this.account = account;
    }

    @Override
    public Double call() throws Exception {
        if (isWithdrawal) {
            if (money <= account.getBalance()) {
                account.withdrawal(-money);
            }
        } else {
            account.deposit(money);
        }
        return account.getBalance();
    }
}

