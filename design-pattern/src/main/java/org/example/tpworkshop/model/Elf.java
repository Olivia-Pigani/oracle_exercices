package org.example.tpworkshop.model;

import org.example.tpworkshop.Observer;

public class Elf implements Observer {

    private static int idIncrementor = 0;

    private int id;

    private String name;

    public Elf(String name) {
        this.id = ++idIncrementor;
        this.name = name;
    }

    @Override
    public void toyMakingNotification(String message) {
        System.out.println(name + " a reçu un message : " + message);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
