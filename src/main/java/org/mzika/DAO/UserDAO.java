package org.mzika.DAO;

import org.mzika.orm.User;

public interface UserDAO {
    public User saveUser(User user);
    public User getUser(User user);
    public User updateUser(User user);
    public  boolean deleteUser(int id);
}
