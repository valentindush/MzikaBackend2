package org.mzika.DAO;

import org.mzika.orm.Playlist;

public interface PlaylistDAO {

    public Playlist savePlaylist(Playlist playlist);
    public Playlist updatePlaylist(Playlist playlist);
    public  Playlist getPlaylist(int id);
    public boolean deletePlaylist(int id);
}
