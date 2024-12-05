package org.example.decorator;

public class LowerCaseDecorator extends TextDecorator{
    public LowerCaseDecorator(IText text) {
        super(text);
    }

    @Override
    public String transform() {
        return super.transform().toLowerCase();
    }
}
