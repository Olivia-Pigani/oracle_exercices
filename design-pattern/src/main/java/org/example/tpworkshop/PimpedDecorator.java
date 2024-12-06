package org.example.tpworkshop;

import org.example.tpworkshop.model.IToy;

public class PimpedDecorator extends ToyDecorator {
    public PimpedDecorator(IToy toy) {
        super(toy);
    }

    @Override
    public void make() {
        super.make();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " but pimped !";
    }
}
