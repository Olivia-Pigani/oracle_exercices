package org.example;

public abstract sealed class LibraryItem permits Book, Magazine{

    private static int id = 0;

    private String title;

    private int publicationYear;

    public LibraryItem(String title, int publicationYear) {
        id++;
        this.title = title;
        this.publicationYear = publicationYear;
    }

     abstract String getDetails();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
