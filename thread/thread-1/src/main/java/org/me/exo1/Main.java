package org.me.exo1;

public class Main {
    public static void main(String[] args) {

        Thread thread;
        for (int i = 0; i < 3; i++) {
            thread = new MonPremierThread();
            thread.start();
        }


    }
}