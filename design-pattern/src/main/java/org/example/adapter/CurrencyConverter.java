package org.example.adapter;

public class CurrencyConverter {

    public double convertFromUSD(AvailableCurrency currency, double amount) {

        switch (currency) {
            case EUR -> {
                return amount * 0.95;
            }
            case YEN -> {
                return amount * 152;
            }
        }

        throw new IllegalArgumentException();
    }

    public double convertToUSD(AvailableCurrency currency, double amount) {

        switch (currency) {
            case EUR -> {
                System.out.println("EUR to USD");
                return amount * 1.2;
            }
            case YEN -> {
                System.out.println("YEN to USD");
                return amount * 0.0063;
            }
        }

        throw new IllegalArgumentException();
    }


}
