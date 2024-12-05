package org.example.observer;

public class PhoneDisplay implements Observer{
    private String weather;
    @Override
    public void update(String weather) {
    this.weather=weather;
    display();
    }
    private void display(){
        System.out.println("phone updated : " + weather);
    }
}
