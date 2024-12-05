package org.example.observer;

public class WeatherApp {
    public static void main(String[] args) {
        WeatherStationConcrete weatherStation = new WeatherStationConcrete();

        Observer phone = new PhoneDisplay();
        Observer tv = new TvDisplay();

        weatherStation.addObserver(phone);
        weatherStation.addObserver(tv);

        weatherStation.setWeather("Sunny");
    }
}
