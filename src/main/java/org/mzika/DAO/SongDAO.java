package org.mzika.DAO;

import org.mzika.orm.Song;

public interface SongDAO {

    public Song create(Song song);
    public Song updateSong(Song song, int id);
    public Song getSong(int id);
    public Song deleteSong(int id);
}
