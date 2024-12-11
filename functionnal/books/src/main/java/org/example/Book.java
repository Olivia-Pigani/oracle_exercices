package org.example;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {

    private String title;

    private String author;

    private String genre;

    private LocalDate publicationDate;

    private int pageNumber;

    private boolean isAvailable;

    private double price;

    public Book(String title, String author, String genre, String publicationDate, int pageNumber, boolean isAvailable,double price) throws ParseException {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationDate = setPublicationDate(publicationDate);
        this.pageNumber = pageNumber;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public LocalDate setPublicationDate(String publicationDateStr) throws ParseException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(publicationDateStr, dateTimeFormatter);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publicationDate=" + publicationDate +
                ", pageNumber=" + pageNumber +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                '}';
    }
}
