package org.example;

public class Product {

    private static int idIncrementor = 0;

    private int id;

    private String name;

    private double price;

    private double quantity;

    public Product(String name, double price, double quantity) {
        this.id = ++idIncrementor;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
