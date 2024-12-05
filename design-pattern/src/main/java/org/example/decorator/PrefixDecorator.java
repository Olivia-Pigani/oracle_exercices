package org.example.decorator;

public class PrefixDecorator extends TextDecorator{
    public PrefixDecorator(IText text) {
        super(text);
    }

    @Override
    public String transform() {
        return "hola" + super.transform();
    }
}
