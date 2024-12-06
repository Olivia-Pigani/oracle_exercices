package org.example.command;

public class Main {
    public static void main(String[] args) {
        Track track = new Track("SHine on you crazy diamond", "Pink Floyd");
        Command trackAdded = new AddTrackCommand(track);
        Command trackRemoved = new RemoveTrackCommand(track);
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(trackAdded);
        remoteControl.pressButton();

        remoteControl.setCommand(trackRemoved);
        remoteControl.pressButton();
    }
}
