package org.example;

public final class Book extends LibraryItem {

    private String author;

    private String genre;

    public Book(String title, int publicationYear, String author, String genre) {
        super(title, publicationYear);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    String getDetails() {
        return "book: " + " title: " + getTitle() + " publication year " + getPublicationYear() + " the author:  " + author + " genre : " + genre;
    }
}
