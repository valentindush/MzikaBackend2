package org.mzika.DAOimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mzika.DAO.PlaylistDAO;
import org.mzika.orm.Playlist;

public class PlaylistDAOimpl implements PlaylistDAO {

    private final Session session;
    Transaction transaction = null;

    public PlaylistDAOimpl(Session session){
        this.session = session;
    }

    @Override
    public Playlist savePlaylist(Playlist Playlist) {

        try {

            transaction = this.session.beginTransaction();
            session.save(Playlist);
            transaction.commit();

            return Playlist;

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Playlist getPlaylist(int id) {

        try{

            transaction = this.session.beginTransaction();
            return (Playlist) session.get(Playlist.class, id);

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Playlist updatePlaylist(Playlist Playlist) {

        try{

            transaction = this.session.beginTransaction();
            session.update(Playlist);
            transaction.commit();

            return  Playlist;
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public boolean deletePlaylist(int id) {

        try{
            transaction = session.beginTransaction();
            Playlist Playlist = (Playlist) session.get(Playlist.class , id);
            if(Playlist != null){
                session.delete(Playlist);
            }
            transaction.commit();
            return  true;
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }

    }
}
