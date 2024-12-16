package org.me.exo3;

import java.util.concurrent.Callable;

public class CalculateurCallable implements Callable<String> {

    private int number;

    public CalculateurCallable(int number) {
        this.number = number;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        return "Le cube de " + number + " est de " + Math.cbrt(number);
    }
}
