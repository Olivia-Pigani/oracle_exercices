package org.example.adapter;

public class Adapter implements ICurrencyAdapter{

    private final CurrencyConverter currencyConverter;

    public Adapter(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public double convert(AvailableCurrency fromCurrency, double amount) {

        if (fromCurrency.equals(AvailableCurrency.USD)){
            return currencyConverter.convertFromUSD(fromCurrency,amount);
        }else{
            return currencyConverter.convertToUSD(fromCurrency,amount);
        }

    }

}
