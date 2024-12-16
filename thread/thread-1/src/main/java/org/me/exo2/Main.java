package org.me.exo2;

public class Main {

    public static void main(String[] args) {

        Thread thread;
        for (int i = 0; i < 6; i++) {

            thread = new Thread(new MaTacheRunnable(i));
            thread.start();


        }


    }

}
