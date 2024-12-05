package org.example.decorator;

public class UpperCaseDecorator extends TextDecorator{
    public UpperCaseDecorator(IText text) {
        super(text);
    }

    @Override
    public String transform() {
        return super.transform().toUpperCase();
    }
}
