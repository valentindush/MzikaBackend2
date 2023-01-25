package org.mzika.orm.DAO;

import org.mzika.orm.User;

public interface UserDAO {
    public User saveUser(User user);
    public User getUser(int id);
    public User updateUser(User user);
    public  boolean deleteUser(int id);
}
