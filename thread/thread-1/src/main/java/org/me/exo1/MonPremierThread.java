package org.me.exo1;

public class MonPremierThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + "Compteur : " + i);
        }
    }
}
