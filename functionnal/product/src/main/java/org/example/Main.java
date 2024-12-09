package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = Arrays.asList(
                new Product("eraser", 10.02, 10.00),
                new Product("bottle", 1.02, 105.00),
                new Product("sticker", 1L, 0.00),
                new Product("monitor", 420.01, 25.00),
                new Product("Sheet of paper", 0.50, 15.50),
                new Product("table", 102L, 4.00)
        );

        Consumer<String> messagePrinter = m-> System.out.println(m);
        messagePrinter.accept("product list is composed of : ");
        productList.forEach(p->messagePrinter.accept(p.getName() + " quantity: " + p.getQuantity() + " price: " + p.getPrice()) );

        //filter available quantities
        messagePrinter.accept("all available products in stock: ");
        ProductFilter<Product, Double> productFilterQuantity = (product, quantity) -> product.getQuantity() > quantity;

        AtomicBoolean result = new AtomicBoolean(false);
        productList.forEach(product -> {
            result.set(productFilterQuantity.isProductHere(product, 0.00));
            messagePrinter.accept(String.valueOf(result));
        });

        //filter by name
        messagePrinter.accept("find eraser product in the list: ");
        ProductFilter<Product,String> productFilterName = (product, name) -> product.getName().equals(name);
        String searchedItem = "eraser";
        Optional<Product> foundedProduct = productList.stream()
                .filter(product -> productFilterName.isProductHere(product,searchedItem))
                .findFirst();

        //inscrease price
        Product productToTransform = productList.get(0);
        messagePrinter.accept("chosen product: " + productToTransform.getName() + " with price: " + productToTransform.getPrice() + " with stock of: " + productToTransform.getQuantity() + " add 5 euros");
        double amountToAdd = 5.00;
        ProductTransformation<Product,Double> increasePriceFilter = (product, amount) -> product.setPrice(product.getPrice() + amount);
        increasePriceFilter.transformProduct(productToTransform, amountToAdd);
        messagePrinter.accept("product is now updated: " + productToTransform.getName() + " with price: " + productToTransform.getPrice());

        //low the price
        messagePrinter.accept("let's low the price of 2 euros !");
        double amountToSubstract = 2.00;
        ProductTransformation<Product,Double> subtractPriceFilter = (product, amount) -> product.setPrice(product.getPrice() - amount);
        subtractPriceFilter.transformProduct(productToTransform, amountToSubstract);
        messagePrinter.accept("product is now updated: " + productToTransform.getName() + " with price: " + productToTransform.getPrice());

        //same but for stock quantity
        messagePrinter.accept("let's increase stock of 2 quantities ");
        double quantitiesToAdd = 45.00;
        ProductTransformation<Product,Double> addQuantity = (product, amount) -> product.setQuantity(product.getQuantity() + quantitiesToAdd);
        addQuantity.transformProduct(productToTransform, quantitiesToAdd);
        messagePrinter.accept("product is now updated: " + productToTransform.getQuantity());

        double quantitiesToRemove = 14.00;
        ProductTransformation<Product,Double> removeQuantity = (product, amount) -> product.setQuantity(product.getQuantity() + quantitiesToRemove);
        addQuantity.transformProduct(productToTransform, quantitiesToRemove);
        messagePrinter.accept("product is now updated: " + productToTransform.getQuantity());

        //final functionnal interface for the promotion
        ProductTransformation<Product,String> addPrefix = (product,prefix)-> product.setName(prefix + " " + product.getName());




    }
}