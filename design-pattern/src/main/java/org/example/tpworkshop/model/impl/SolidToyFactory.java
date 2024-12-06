package org.example.tpworkshop.model.impl;

import org.example.tpworkshop.model.IToy;

public class SolidToyFactory extends ToyFactory{

    @Override
    public IToy makeToy() {
        return new SolidIToyImpl();
    }
}
