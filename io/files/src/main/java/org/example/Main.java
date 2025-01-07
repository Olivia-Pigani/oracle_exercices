package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        TextFileHandler handler = new TextFileHandler();

        List<String> stringList = handler.textReader();

        handler.textWriter(stringList);


    }
}