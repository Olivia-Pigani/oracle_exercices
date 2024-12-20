package org.example.perf;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static CopyOnWriteArrayList<Integer> arrayListForNative = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<Integer> arrayListForVirtual = new CopyOnWriteArrayList<>();
    private static int threadCount = 100;


    public static void main(String[] args) {

        calcNativeThreadsPerf();

        calcVirtualThreadsPerf();

    }


    private static void calcNativeThreadsPerf() {

        long startTime = System.currentTimeMillis();

        try (ExecutorService executorService = Executors.newFixedThreadPool(threadCount)){
            for (int i = 0; i < threadCount; i++) {
                executorService.execute(threadMaker(arrayListForNative));
            }

        }catch (OutOfMemoryError ex){
            ex.printStackTrace();
    }



        long endTime = System.currentTimeMillis();

        System.out.println("total execution time for NATIVE THREADS " + (endTime - startTime) + " ms");
}

private static void calcVirtualThreadsPerf() {

    long startTime = System.currentTimeMillis();



    try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

        for (int i = 0; i < threadCount; i++) {
            executorService.execute(threadMaker(arrayListForVirtual));
        }

    }catch (OutOfMemoryError ex){
        ex.printStackTrace();
    }


    long endTime = System.currentTimeMillis();
    System.out.println("total execution time for VIRTUAL THREADS " + (endTime - startTime) + " ms");


}

private static Thread threadMaker(CopyOnWriteArrayList<Integer> arrayList) {
    return new Thread(() -> {

        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }
    });
}

;
}