package org.example.concurrentlinkedqueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExo {

    public static void main(String[] args) throws InterruptedException {


        ConcurrentLinkedQueue<String> elements = new ConcurrentLinkedQueue<>();

        managment(elements);

    }


    private static void managment(ConcurrentLinkedQueue<String> elements) throws InterruptedException {

        Runnable addTask = () -> {
            for (int i = 0; i < 10; i++) {
                String elementToAdd = Thread.currentThread().getName() + "-Element-" + i;
                elements.add(elementToAdd);
                System.out.println(Thread.currentThread().getName() + " a ajouté : " + elementToAdd);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable removeTask = () -> {
            for (int i = 0; i < 10; i++) {

                String element = elements.poll();

                if (element != null) {
                    System.out.println(Thread.currentThread().getName() + " a retiré : " + element);
                } else {
                    System.out.println(Thread.currentThread().getName() + " n'a trouvé aucun élément à retirer.");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread producer = new Thread(addTask, "Producer");
        Thread consumer = new Thread(removeTask, "Consumer");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("liste finale : " + elements);
    }

}
