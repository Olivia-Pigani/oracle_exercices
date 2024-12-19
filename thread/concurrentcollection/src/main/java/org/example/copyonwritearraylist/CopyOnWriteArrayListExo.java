package org.example.copyonwritearraylist;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CopyOnWriteArrayListExo {

    public static void main(String[] args) throws InterruptedException {


        List<String> products = new CopyOnWriteArrayList<>();

        addProduct(products);

    }


    public static void addProduct(List<String> productsList) throws InterruptedException {

        AtomicInteger counter = new AtomicInteger(0);

        Runnable taskToAddProduct = () -> {
            for (int i = 0; i < 5; i++) {
                productsList.add(Thread.currentThread().getName() + "-product" + counter.getAndIncrement());

            }
        };

        Thread t1 = new Thread(taskToAddProduct, "Thread-1");
        Thread t2 = new Thread(taskToAddProduct, "Thread-2");


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Liste finale des produits : " + productsList);
    }

}
