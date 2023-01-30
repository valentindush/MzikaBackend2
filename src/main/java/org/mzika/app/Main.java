package org.mzika.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mzika.DAOimpl.UserDAOimpl;
import org.mzika.orm.User;

public class Main {
    public static void main(String[] args) {

        //Load configuration file

        System.out.println("The configuration are being loaded");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        System.out.println("The configuration files have been loaded");

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        //Save the user into the database

        User user = new User("Emmy", "emmymanuel@gmail.com", "dushCode@123");

        UserDAOimpl userDAOimpl = new UserDAOimpl(session);

        userDAOimpl.saveUser(user);

        //Close the connection

        session.close();
        factory.close();

    }
}