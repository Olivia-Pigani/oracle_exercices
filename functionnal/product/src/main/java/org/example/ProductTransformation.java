package org.example;

@FunctionalInterface
public interface ProductTransformation<T, U> {
    void transformProduct(T product, U change);
}
