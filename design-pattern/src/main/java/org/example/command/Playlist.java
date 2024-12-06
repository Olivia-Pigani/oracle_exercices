package org.example.command;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String name;

    private String genre;

    List<Track> trackList = new ArrayList<>();

    public Playlist(String name, String genre) {
        this.name = name;
        this.genre = genre;
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

    public void addSong(Track track){
        trackList.add(track);
        System.out.println("the song " + track.getName() + " of " + track.getSinger() + " has been add from the playlist " + name + " with the genre " + genre);
    }

    public void removeSong(Track track){
        trackList.add(track);
        System.out.println("the song " + track.getName() + " of " + track.getSinger() + " has been removed from the playlist " + name + " with the genre " + genre);
    }
}
