package org.me.bank;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Double> {


    private double balance;

    private double money;

    //withdraw is false, deposit is true
    private boolean isWithdrawal = false;

    public MyCallable( boolean isWithdrawal, double money) {
        this.isWithdrawal = isWithdrawal;
        this.money = money;
    }

    @Override
    public Double call() throws Exception {
        if (!isWithdrawal){
            balance+=money;
        } else {
            if (money<=balance){
                balance-=money;
            }
        }
        return balance;
    }

}
