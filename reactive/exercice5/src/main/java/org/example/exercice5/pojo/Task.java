package org.example.exercice5.pojo;

public class Task {

    private static int idIncrementor = 0;

    private int id;

    private String description;

    private boolean isCompleted;

    public Task(String description, boolean isCompleted) {
        this.id = ++idIncrementor;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
