package org.me.exo7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(1);

        try (ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ) {

            Runnable runnable = new MyRunnable(atomicInteger.get());

            scheduledExecutorService.scheduleAtFixedRate(runnable,
                    1000,
                    2000,
                    TimeUnit.MILLISECONDS);

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }


}
