package org.example;

import java.util.List;

@FunctionalInterface
public interface ProductOperation<T> {
    void operations (T product);
}
