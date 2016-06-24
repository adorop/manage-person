package by.it.academy.adorop.dao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();

    private static SessionFactory sessionFactory;
    private static Session session;

    static {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CustomNamingStrategy());
        sessionFactory = configuration.configure().buildSessionFactory();
    }

    public static Session getSession() {
        session = sessionThreadLocal.get();
        if (session == null) {
            session = sessionFactory.openSession();
            sessionThreadLocal.set(session);
        }
        return session;
    }

    public static void realizeResources() {
        getSession().close();
        sessionFactory.close();
    }
}
