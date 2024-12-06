package org.example.command;

public class AddTrackCommand implements Command{
    private Track track;

    public AddTrackCommand(Track track) {
        this.track = track;
    }

    @Override
    public void execute() {
        track.addSong();
    }
}
