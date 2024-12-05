package org.example.tpworkshop.model.impl;

import org.example.tpworkshop.model.IToy;

public class FragileToyimpl implements IToy {

    @Override
    public void make() {
        System.out.println("fragile toy has been maked");
    }

    @Override
    public String getDescription() {
        return "";
    }

}
