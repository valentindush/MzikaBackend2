package org.mzika.utils; /**
 *
 */

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Session factory for smis configures hibernate configuration file
 *
 * @author DUSH
 *
 */
public class SessionFactory {

    private static org.hibernate.SessionFactory sessionFactory;

    private SessionFactory() {
    }

    /**
     * gets instance
     *
     * @return sessionFactory
     */
    private static org.hibernate.SessionFactory getInstance() throws HibernateException{
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            String configFile = "hibernate.cfg.xml";
            configuration.configure(configFile);
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    /**
     * gets session
     *
     * @return session
     */
    public static Session getSession() {
        Session session = getInstance().getCurrentSession();
        if (session == null || !session.isOpen()) {
            session = getInstance().openSession();
        }
        return session;
    }

}