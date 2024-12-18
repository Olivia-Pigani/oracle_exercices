package org.me.tab;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Tab {

    public static void main(String[] args) {

        Integer[] integerArr = new Integer[5];

        for (int i = 0; i < integerArr.length; i++) {
            integerArr[i] = i;
        }

        AtomicInteger sum = new AtomicInteger(0);


        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("somme totale : " + sum.get());
        });

        Runnable task = () -> {
            try {
                Random random = new Random();
                int indice1 = random.nextInt(integerArr.length);
                int indice2 = random.nextInt(integerArr.length);
                int result = integerArr[indice1] + integerArr[indice2];
                System.out.println(Thread.currentThread().getName() + " a calculé une somme partielle de " + indice1 + " à " + indice2 + " = " + result);
                sum.addAndGet(result);
                cyclicBarrier.await();
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        new Thread(task, "thread 1").start();
        new Thread(task, "thread 2").start();
        new Thread(task, "thread 3").start();
        new Thread(task, "thread 4").start();

    }
}
