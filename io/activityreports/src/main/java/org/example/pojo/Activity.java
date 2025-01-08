package org.example.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity {

    private String description;

    private String date;

    public Activity(String description) {
        this.description = description;
        this.date = new SimpleDateFormat("dddd-MM-dd HH:mm:ss").format(new Date());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "activity : " + description + " has been made at : " + date;
    }
}
