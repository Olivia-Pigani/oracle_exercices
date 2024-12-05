package org.example.decorator;

public class Text implements IText {

    private String myText;

    public Text(String myText) {
        this.myText=myText;
    }

    @Override
    public String transform() {
        return myText;
    }
}
