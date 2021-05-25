package hibernateannotationsmapping;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

public class HibernateAnnotationsMapping {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.createSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person p = new Person("Peter", "Smith", 35);
        session.save(p);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
