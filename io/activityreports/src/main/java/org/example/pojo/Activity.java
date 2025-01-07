package org.example.pojo;

import java.time.LocalDateTime;

public class Activity {

    private String description;

    private LocalDateTime date;

    public Activity(String description, LocalDateTime date) {
        this.description = description;
        this.date = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "activity : " + description + " has been made at : " + date;
    }
}
