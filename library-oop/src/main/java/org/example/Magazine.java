package org.example;

public final class Magazine extends LibraryItem {

    private int issueNumber;

    public Magazine(String title, int publicationYear, int issueNumber) {
        super(title, publicationYear);
        this.issueNumber = issueNumber;
    }

    public Magazine(String title, int publicationYear) {
        super(title, publicationYear);
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    String getDetails() {
        return "magazine :" + "title: " + this.getTitle() + "publication year: " + this.getPublicationYear() ;
    }
}
