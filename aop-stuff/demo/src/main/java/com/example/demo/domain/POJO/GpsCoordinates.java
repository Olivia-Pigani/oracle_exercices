package com.example.demo.domain.POJO;

import jakarta.persistence.Embeddable;

@Embeddable
public class GpsCoordinates {

    private double latitude;

    private double longitude;


    public GpsCoordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public GpsCoordinates() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}




