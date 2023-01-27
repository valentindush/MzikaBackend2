package org.mzika.orm.DAO;

import org.mzika.orm.Song;

import java.util.List;

public interface SongDAO {

    public Song create(Song song);
    public Song updateSong(Song song, int id);
    public Song getSong(int id);
    public Song deleteSong(int id);

    public List<Song> getAllSong();
}
