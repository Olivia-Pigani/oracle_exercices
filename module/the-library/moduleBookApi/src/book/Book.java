package book;

public class Book {

    private static int idIncrementor = 0;

    private int id;

    private String author;

    private String title;


    public Book(String author, String title) {
        this.id = ++idIncrementor;
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return "the book " + id + " is " + title + " the author is " + author;
    }


}