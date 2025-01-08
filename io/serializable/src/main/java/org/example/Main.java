package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String SER_FILE_PATH = "src/main/resources/book.ser";

    public static void main(String[] args) {

        List<Book> library = Arrays.asList(
                new Book("Harry Potter", "jk Rowling"),
                new Book("GOT", "George RR Martin")
        );

        serializeLibrary(library);

        List<Book> newLibraryList = deserializeLibrary();
        System.out.println(newLibraryList);


    }

    public static void serializeLibrary(List<Book> library) {
        //Serialize
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(SER_FILE_PATH))) {

            for (Book book : library) {
                objectOutputStream.writeObject(book);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static List<Book> deserializeLibrary() {

        List<Book> deserializedLibrary = new ArrayList<>();

        //Deserialize
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(SER_FILE_PATH))) {

            while (true) {
                try {
                    Book book = (Book) objectInputStream.readObject();
                    deserializedLibrary.add(book);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return deserializedLibrary;
    }
}