package org.mzika.DAO;

import org.mzika.orm.User;

import java.util.List;

public interface UserDAO {
    public User saveUser(User user);
    public User getUser(int id);
    public User updateUser(User user);
    public  boolean deleteUser(int id);

    public List<User> getAllUsers();
}
