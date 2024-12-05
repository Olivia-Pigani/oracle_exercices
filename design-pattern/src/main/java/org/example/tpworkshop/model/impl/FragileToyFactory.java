package org.example.tpworkshop.model.impl;

import org.example.tpworkshop.model.IToy;

public class FragileToyFactory extends ToyFactory{

    @Override
    public IToy makeToy() {
        return new FragileToyimpl();
    }
}
