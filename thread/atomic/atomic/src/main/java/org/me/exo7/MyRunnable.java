package org.me.exo7;


import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable implements Runnable {

    private int index;


    public MyRunnable(int index) {
        this.index = index;
    }

    @Override
    public void run() {

        System.out.println("Message périodique " + index);

        if (index >= 5) {
            System.out.println("programme terminé");
        }
    }
}
