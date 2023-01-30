package org.mzika.DAO;

import org.mzika.orm.Song;

import java.util.List;

public interface SongDAO {


    public Song updateSong(Song song);

    Song createSong(Song song);

    public Song getSong(int id);
    public boolean deleteSong(int id);

    public List<Song> getAllSongs();
}
