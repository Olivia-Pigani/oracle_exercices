package org.example.adapter;

//the class to use but can't be changed
public class CurrencyConverter {

    public double convertFromUSD(AvailableCurrency currency, double amount) {

        switch (currency) {
            case EUR -> {
                return amount * 0.95;
            }
            case YEN -> {
                return amount * 152;
            }
            default -> throw new IllegalArgumentException();
        }
    }

    public double convertToUSD(AvailableCurrency currency, double amount) {

        return switch (currency) {
            case EUR -> amount * 1.2;
            case YEN -> amount * 0.0063;
            default -> throw new IllegalArgumentException();
        };

    }


}
