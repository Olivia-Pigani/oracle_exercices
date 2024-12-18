package org.me.printer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {

    private static ReentrantLock lock = new ReentrantLock();

    public Printer() {
    }

    public static void getResource() {
        System.out.println(Thread.currentThread().getName() + " tente d'utiliser l'imprimante ... ");

        try {
            if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName() + " a acquis le verrou et utilise l'imprimante");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " a terminé d'utiliser l'imprimante et libère le verrou");
                lock.unlock();
            } else {
                System.out.println(Thread.currentThread().getName() + " n'a pas pu accéder à l'imprimante");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " a été interrompu");
        }

    }

}
