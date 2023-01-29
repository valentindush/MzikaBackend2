package org.mzika.DAO;

import org.mzika.orm.Artist;

public interface ArtistDAO {
    public Artist saveArtist(Artist artist);
    public Artist updateArtist(Artist artist, int id);
    public Artist getArtist(int id);
    public  boolean deleteArtist(int id);
}
