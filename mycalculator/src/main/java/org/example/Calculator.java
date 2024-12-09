package org.example;

    @FunctionalInterface
    public interface Calculator<T extends Number>{

        T action(T nb1, T nb2);

    }

