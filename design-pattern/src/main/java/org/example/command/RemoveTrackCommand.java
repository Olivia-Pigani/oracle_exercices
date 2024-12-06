package org.example.command;

public class RemoveTrackCommand implements Command{
    private Track track;

    public RemoveTrackCommand(Track track){
        this.track = track;
    }

    @Override
    public void execute() {
        track.removeSong();
    }
}
