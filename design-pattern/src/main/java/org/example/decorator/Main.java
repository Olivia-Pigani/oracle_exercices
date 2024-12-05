package org.example.decorator;

public class Main {
    public static void main(String[] args) {


        IText startText = new Text();
        System.out.println(startText.transform());

        IText upperCaseText = new UpperCaseDecorator(startText);
        System.out.println(upperCaseText.transform());

        IText lowerCaseText = new LowerCaseDecorator(upperCaseText);
        System.out.println(lowerCaseText.transform());

        IText prefixText = new PrefixDecorator(lowerCaseText);
        System.out.println(prefixText.transform());

        IText suffixText = new SuffixDecorator(prefixText);
        System.out.println(suffixText.transform());

    }
}
