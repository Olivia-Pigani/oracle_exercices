package org.example.command;

public class Track {

    private String name;

    private String singer;

    public Track(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void addSong(){
        System.out.println("the song " + name + " of " + singer + " has been put into the playlist");
    }

    public void removeSong(){
        System.out.println("the song " + name + " of " + singer + " has been removed from the playlist");
    }
}
