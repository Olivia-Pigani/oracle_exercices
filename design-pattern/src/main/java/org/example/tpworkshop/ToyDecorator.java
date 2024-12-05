package org.example.tpworkshop;

import org.example.tpworkshop.model.IToy;

public abstract class ToyDecorator implements IToy {

    protected IToy toy;

    public ToyDecorator(IToy toy) {
        this.toy = toy;
    }

    @Override
    public void make() {

    }

    @Override
    public String getDescription() {
        return toy.getDescription();
    }
}
