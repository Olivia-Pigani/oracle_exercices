package org.example.adapter;

public class Main {

    public static void main(String[] args) {

        CurrencyConverter currencyConverter = new CurrencyConverter();
        ICurrencyAdapter currencyAdapter = new Adapter(currencyConverter);

        double startAmount = 10;

        System.out.println(currencyAdapter.convert(AvailableCurrency.EUR, startAmount));

    }
}
