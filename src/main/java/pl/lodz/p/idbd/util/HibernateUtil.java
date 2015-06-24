package pl.lodz.p.idbd.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import pl.lodz.p.idbd.model.Book;
import pl.lodz.p.idbd.model.Reservation;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration config = new Configuration();
            config.configure();
            config.addAnnotatedClass(Book.class);
            config.addAnnotatedClass(Reservation.class);

            // Create the SessionFactory from hibernate.cfg.xml
            return config.buildSessionFactory(
                    new StandardServiceRegistryBuilder().build() );
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}