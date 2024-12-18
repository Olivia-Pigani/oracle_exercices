package org.me.sharedresources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(5);
        integerList.add(6);
        integerList.add(8);

        SharedResource sharedResource = SharedResource.getInstance(integerList);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        Random random = new Random();

        for (int i = 0; i < 5; i++) {

            Callable<List<Integer>> callableTaskAdd = () -> {
                Integer randomInteger = random.nextInt();
                return sharedResource.addElement(randomInteger);
            };

            Future<List<Integer>> resultFuture = scheduledExecutorService.submit(callableTaskAdd);
            List<Integer> result = resultFuture.get();

            System.out.println(result);

        }

        Callable<List<Integer>> callableTaskRemove = () -> {
            return sharedResource.removeElement(5);
        };


        scheduledExecutorService.shutdown();

    }
}
