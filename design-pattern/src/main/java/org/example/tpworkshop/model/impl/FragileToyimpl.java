package org.example.tpworkshop.model.impl;

import org.example.tpworkshop.model.IToy;

public class FragileToyimpl implements IToy {

    private static int idIncrementor = 0;

    private int id;

    private String name = "fragile toy";

    public FragileToyimpl() {
        this.id = ++idIncrementor;
        this.name = name;
    }

    @Override
    public void make() {
        System.out.println("fragile toy has been maked");
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String toString() {
        return "FragileToyimpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
