package com.example.demo.domain.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ObservationId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id_human;
    private Long id_ovni;

    public ObservationId(Long humanId, Long ovniId) {
        super();
        this.id_human = humanId;
        this.id_ovni = ovniId;
    }

    public ObservationId() {
    }

    public Long getHumanId() {
        return id_human;
    }

    public void setHumanId(Long humanId) {
        this.id_human = humanId;
    }

    public Long getOvniId() {
        return id_ovni;
    }

    public void setOvniId(Long ovniId) {
        this.id_ovni = ovniId;
    }

}
