package org.example.quizz.domain.model;

public class Player {

    private static long idIncrementor = 0;

    private long id;

    private String userName;

    public Player(long id, String userName) {
        this.id = ++idIncrementor;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

}
