package org.me.aop.model;

import java.time.LocalDate;

public class Book {

    private static int idIncrementor = 0;

    private int id;

    private String title;

    private LocalDate date;

    private String author;

    public Book(String title, LocalDate date, String author) {
        this.id = ++idIncrementor;
        this.title = title;
        this.date = date;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", author='" + author + '\'' +
                '}';
    }
}
