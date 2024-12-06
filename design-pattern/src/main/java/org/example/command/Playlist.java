package org.example.command;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String name;

    private String genre;

    List<Track> trackList = new ArrayList<>();

    public Playlist(String name, String genre, List<Track> trackList) {
        this.name = name;
        this.genre = genre;
        this.trackList = trackList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }
}
