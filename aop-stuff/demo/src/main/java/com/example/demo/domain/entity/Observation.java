package com.example.demo.domain.entity;

import com.example.demo.domain.POJO.GpsCoordinates;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "observations")
public class Observation {

    @EmbeddedId
    private ObservationId id = new ObservationId();

    private LocalDate date;

    private String description;

    @Embedded
    private GpsCoordinates gpsCoordinates;

    @ManyToOne
    @MapsId("id_human")
    private Human human;

    @ManyToOne
    @MapsId("id_ovni")
    private OVNI ovni;

    public ObservationId getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GpsCoordinates getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(GpsCoordinates gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public OVNI getOvni() {
        return ovni;
    }

    public void setOvni(OVNI ovni) {
        this.ovni = ovni;
    }
}
