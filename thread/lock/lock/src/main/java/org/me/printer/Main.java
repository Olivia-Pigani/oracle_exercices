package org.me.printer;

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(Printer::getResource, "tache 1");
        Thread t2 = new Thread(Printer::getResource, "tache 2");
        Thread t3 = new Thread(Printer::getResource, "tache 3");

        // Lancer les threads
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Toutes les tâches sont terminées.");

    }
}
