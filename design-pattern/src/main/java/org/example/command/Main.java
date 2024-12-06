package org.example.command;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();
        Playlist rockPlaylist = new Playlist("rockPlaylist", "rock");

        Track track1 = new Track("SHine on you crazy diamond", "Pink Floyd");
        Track track2 = new Track("Logical", "Supertramp");

        Command trackAdded = new AddTrackCommand(rockPlaylist,track1);
        Command trackAdded2 = new AddTrackCommand(rockPlaylist,track2);
        Command trackRemoved = new RemoveTrackCommand(rockPlaylist,track1);

        remoteControl.setCommand(trackAdded);
        remoteControl.pressButton();

        remoteControl.setCommand(trackAdded2);
        remoteControl.pressButton();

        remoteControl.setCommand(trackRemoved);
        remoteControl.pressButton();
    }
}
