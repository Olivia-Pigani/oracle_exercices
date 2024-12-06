package org.example.tpworkshop.model.impl;

import org.example.tpworkshop.model.IToy;

public class SolidIToyImpl implements IToy {


    private static int idIncrementor = 0;

    private int id;

    private String name = "solid toy";

    public SolidIToyImpl() {
        this.id = ++idIncrementor;
        this.name = name;
    }

    @Override
    public void make() {
        System.out.println("solid toy has been maked");

    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String toString() {
        return "SolidIToyImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
