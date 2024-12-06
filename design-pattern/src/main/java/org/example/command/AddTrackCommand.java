package org.example.command;

public class AddTrackCommand implements Command{
    private Playlist playlist;
    private Track track;

    public AddTrackCommand(Playlist playlist,Track track) {
        this.playlist=playlist;
        this.track = track;
    }

    @Override
    public void execute() {
        playlist.addSong(track);
    }
}
