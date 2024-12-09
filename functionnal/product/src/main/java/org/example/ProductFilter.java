package org.example;

@FunctionalInterface
public interface ProductFilter<T, U> {

    boolean isProductHere(T product, U toCheck);

}
