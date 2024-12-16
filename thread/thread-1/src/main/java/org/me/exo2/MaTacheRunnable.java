package org.me.exo2;

public class MaTacheRunnable implements Runnable {

    private final double numberToChange;

    public MaTacheRunnable(int numberToChange) {
        this.numberToChange = numberToChange;
    }

    @Override
    public void run() {
        System.out.println("Le carré de " + numberToChange + " est " + calcSqrt(numberToChange));
    }

    private double calcSqrt(double nb) {
        return Math.sqrt(nb);
    }
}
