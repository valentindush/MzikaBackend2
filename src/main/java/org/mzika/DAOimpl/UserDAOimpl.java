package org.mzika.DAOimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mzika.DAO.UserDAO;
import org.mzika.orm.User;

public class UserDAOimpl implements UserDAO {

    private Session session;
    Transaction transaction = null;

    public UserDAOimpl(Session session){
        this.session = session;
    }

    @Override
    public User saveUser(User user) {

        try {

            transaction = this.session.beginTransaction();
            session.save(user);
            transaction.commit();

            return user;

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public User getUser(int id) {

        try{

            transaction = this.session.beginTransaction();
            return (User) session.get(User.class, id);

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User updateUser(User user) {
        try{
            transaction = this.session.beginTransaction();
            session.update(user);
            transaction.commit();

            return  user;
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean deleteUser(int id) {

        try{
            transaction = session.beginTransaction();
            User user = (User) session.get(User.class , id);
            if(user != null){
                session.delete(user);
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
