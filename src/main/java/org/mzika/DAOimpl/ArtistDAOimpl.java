package org.mzika.DAOimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mzika.DAO.ArtistDAO;
import org.mzika.orm.Artist;

public class ArtistDAOimpl implements ArtistDAO {

    private final Session session;
    Transaction transaction = null;

    public ArtistDAOimpl(Session session) {
        this.session = session;
    }

    @Override
    public Artist saveArtist(Artist artist) {

        try {

            transaction = this.session.beginTransaction();
            session.save(artist);
            transaction.commit();

            return artist;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Artist updateArtist(Artist artist, int id) {
        return null;
    }

    @Override
    public Artist getArtist(int id) {
        return null;
    }

    @Override
    public boolean deleteArtist(int id) {
        return false;
    }
}
