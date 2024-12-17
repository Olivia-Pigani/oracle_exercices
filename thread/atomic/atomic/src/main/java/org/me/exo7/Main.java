package org.me.exo7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        // Avec Try with resources

        AtomicInteger atomicInteger = new AtomicInteger(1);

        try (ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ) {

            scheduledExecutorService.scheduleAtFixedRate(() -> {
                        int currentCount = atomicInteger.incrementAndGet();
                        System.out.println("Message périodique: " + currentCount);

                        if (currentCount > 4) {
                            System.out.println("fini");
                        }

                    },
                    1000, 2000, TimeUnit.MILLISECONDS
            );

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


// Sans Try with resources

//        AtomicInteger atomicInteger = new AtomicInteger(0);
//
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//                    int currentCount = atomicInteger.incrementAndGet();
//                    System.out.println("Message périodique: " + currentCount);
//
//                    if (currentCount > 4) {
//                        System.out.println("fini");
//                        scheduledExecutorService.shutdown();
//                    }
//
//                },
//                1000, 2000, TimeUnit.MILLISECONDS
//        );
//
//

}



