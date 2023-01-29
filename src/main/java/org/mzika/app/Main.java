package org.mzika.app;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mzika.orm.Song;
import org.mzika.orm.User;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        System.out.println("The configuration are being loaded");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        System.out.println("The configuration files have been loaded");

        Song song = new Song("Voice of the hero", "codesvalentin@gmail.com", 12, "Rap".toLowerCase(Locale.ROOT));

        try {
            SessionFactory factory = configuration.buildSessionFactory();
            Session session = factory.openSession();

            System.out.println("Beginning Transactions..........");
            Transaction transaction = session.beginTransaction();

            session.saveOrUpdate(song);

            System.out.println("Committing transaction.............");
            transaction.commit();
            System.out.println("Before Closing the session");
            session.close();
            factory.close();

        } catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}