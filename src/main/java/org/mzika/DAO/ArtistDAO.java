package org.mzika.DAO;

import jdk.vm.ci.aarch64.AArch64;
import org.mzika.orm.Artist;

import java.util.List;

public interface ArtistDAO {
    public Artist saveArtist(Artist artist);
    public Artist updateArtist(Artist artist, int id);
    public Artist getArtist(int id);
    public  boolean deleteArtist(int id);

    public List<Artist> getAllArtist();
}
