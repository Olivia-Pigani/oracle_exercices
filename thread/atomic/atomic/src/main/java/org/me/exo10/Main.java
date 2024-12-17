package org.me.exo10;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    private static final AtomicLong atomicLong = new AtomicLong(1);

    public static void main(String[] args) throws InterruptedException {


        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            final int multiply = i + 2;
            threads[i] = new Thread(()->{
                long value = atomicLong.updateAndGet(v->v*multiply);
                System.out.println(Thread.currentThread().getName() + " multiplicateur: " + multiply + " result " + value);
            });
            threads[i].start();
        }

        for(Thread thread : threads) {
            thread.join();
        }

        System.out.println("valuer finale :" + atomicLong.get());


    }


}
