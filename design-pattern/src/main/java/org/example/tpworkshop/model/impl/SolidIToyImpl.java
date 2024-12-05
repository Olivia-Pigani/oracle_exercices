package org.example.tpworkshop.model.impl;

import org.example.tpworkshop.model.IToy;

public class SolidIToyImpl implements IToy {
    @Override
    public void make() {
        System.out.println("solid toy has been maked");

    }

    @Override
    public String getDescription() {
        return "";
    }

}
