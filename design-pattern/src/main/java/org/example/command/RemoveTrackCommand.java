package org.example.command;

public class RemoveTrackCommand implements Command{
    private Track track;
    private Playlist playlist;

    public RemoveTrackCommand(Playlist playlist,Track track){
        this.track = track;
        this.playlist = playlist;
    }

    @Override
    public void execute() {
        playlist.removeSong(track);
    }
}
