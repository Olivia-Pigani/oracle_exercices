package org.example;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ConcurrentHashMap<String, Integer> inventory = new ConcurrentHashMap<>();
        inventory.put("ProduitA", 50);
        inventory.put("ProduitB", 30);
        inventory.put("ProduitC", 20);

        management(inventory);
    }

    private static void management(ConcurrentHashMap<String, Integer> inventory) throws InterruptedException {
        Runnable purchaseProduct = () -> {
            for (int i = 0; i < 5; i++) {
                String product = getRandomProduct(inventory);
                inventory.computeIfPresent(product, (k, v) -> {
                    if (v > 0) {
                        System.out.println(Thread.currentThread().getName() + " a acheté 1 unité de " + product);
                        return v - 1;
                    } else {
                        return v;
                    }
                });


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable restockProduct = () -> {
            for (int i = 0; i < 5; i++) {
                String product = getRandomProduct(inventory);
                inventory.compute(product, (k, v) -> (v == null ? 0 : v) + 10);
                System.out.println(Thread.currentThread().getName() + " a réapprovisionné 10 unités de " + product);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(purchaseProduct, "Acheteur-1");
        Thread thread2 = new Thread(purchaseProduct, "Acheteur-2");
        Thread thread3 = new Thread(restockProduct, "Réapprovisionneur");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("l'inventaire final est  : " + inventory);
    }

    private static String getRandomProduct(ConcurrentHashMap<String, Integer> inventory) {
        List<String> products = List.copyOf(inventory.keySet());
        return products.get(ThreadLocalRandom.current().nextInt(products.size()));
    }
}




