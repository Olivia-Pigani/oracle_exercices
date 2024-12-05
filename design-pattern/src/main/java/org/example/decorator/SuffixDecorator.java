package org.example.decorator;

public class SuffixDecorator extends TextDecorator{
    public SuffixDecorator(IText text) {
        super(text);
    }

    @Override
    public String transform() {
        return super.transform() + " hola";
    }
}
