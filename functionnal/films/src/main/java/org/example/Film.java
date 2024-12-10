package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Film {

    private static int idIncrementor = 0;

    private int id;

    private String title;

    private Date date;

    private String realisator;

    private String genre;

    private int entryNb;

    public Film(String title, String date, String realisator, String genre, int entryNb) throws ParseException {
        id = ++idIncrementor;
        this.title = title;
        this.date = setDate(date);
        this.realisator = realisator;
        this.genre = genre;
        this.entryNb = entryNb;
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

    public Date getDate() {
        return date;
    }

    public Date setDate(String date) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return this.date = simpleDateFormat.parse(date);
    }

    public String getRealisator() {
        return realisator;
    }

    public void setRealisator(String realisator) {
        this.realisator = realisator;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getEntryNb() {
        return entryNb;
    }

    public void setEntryNb(int entryNb) {
        this.entryNb = entryNb;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", realisator='" + realisator + '\'' +
                ", genre='" + genre + '\'' +
                ", entryNb=" + entryNb +
                '}';
    }
}
