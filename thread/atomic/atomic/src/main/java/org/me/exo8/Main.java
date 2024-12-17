package org.me.exo8;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {


        Thread[] threads = createAtomicThreads();
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
        System.out.println(atomicInteger.get());

    }

    private static Thread[] createAtomicThreads(){
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.incrementAndGet();
                }
            });
        }
        return threads;
    }
}
