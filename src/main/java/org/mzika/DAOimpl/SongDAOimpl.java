package org.mzika.DAOimpl;

package org.mzika.DAOimpl;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mzika.DAO.SongDAO;
import org.mzika.orm.DAO.SongDAO;
import org.mzika.orm.Song;

import java.util.List;
@Override
public class SongDAOImpl implements SongDAO {

    private Session session;
    Transaction transaction = null;

    public SongDAOImpl(Session session){
        this.session = session;
    }

@Override
    public Song addSong(Song song) {

        try{
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


    @Override
    public Song getSong(int id) {

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


    public Song updateSong(int id, Song song){
        try{
            transaction = session.beginTransaction();
            session.saveOrUpdate(song);
            transaction.commit();
            session.close();
            return (Song) session.update(Song.class, id);

        }
        catch(Exception e){
            if(transaction !=null){
                transaction.rollback();
            }

            e.printStackTrace();
            return null;
        }
    }


    public void deleteSong(String id){
        try{
            transaction= session.beginTransaction();
            Song song = session.get(Song.class , id);
            if (song != null );{
                session.delete(song);
            }
            transaction.commit();
            session.close();
        }
        catch(Exception e){
            if(transaction !=null){
                transaction.rollback();
            }

            e.printStackTrace();
            return;
        }
    }

    public List<Song> getAllSong(){
    try{
        transaction = session.beginTransaction();
        List<Song> songs = session.createCriteria(Song.class);
        transaction.commit();
        session.close();
        return songs;
    }

    catch(Exception e){
        if(transaction !=null){
            transaction.roollback();
        }

        e.printStackTrace();
        return null;
    }

    }
}



