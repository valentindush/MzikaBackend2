package org.mzika.DAOimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mzika.orm.DAO.SongDAO;
import org.mzika.orm.Song;

public class SongDAOimpl implements SongDAO {

    private Session session;
    Transaction transaction = null;

    public SongDAOimpl(Session session){
        this.session = session;
    }

   
    @Override
    public User createSong(Song song) {

       try {

            transaction = this.session.beginTransaction();
            session.save(song);
            transaction.commit();

            return song;

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }

    }

    @Overri
    public User updateSong(int id) {

        try{

            transaction = this.session.beginTransaction();
            session.update(song,id);
            transaction.commit();

            return song ;
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }

    }

    @Override
   @Override
    public User getSong(int id) {

        try{

            transaction = this.session.beginTransaction();
            return (Song) session.get(Song.class, id);

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteSong(int id) {

        try{
            transaction = session.beginTransaction();
            Song song = (Song) session.get(Song.class , id);
            if(song != null){
                session.delete(song);
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