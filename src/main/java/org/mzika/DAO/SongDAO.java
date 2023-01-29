package org.mzika.DAO;

import org.mzika.orm.Song;

public interface SongDAO {


    public Song updateSong(Song song);

    Song createSong(Song song);

    public Song getSong(int id);
    public boolean deleteSong(int id);
}
