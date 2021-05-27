package hibernateannotationsmapping;

import model.Person2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtils5;

public class HibernateAnnotationsMapping {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils5.createSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person2 p = new Person2("Peter", "Smith", 35);
        session.save(p);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
