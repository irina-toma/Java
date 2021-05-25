package simplehibernatemapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//uses person.hbm.xml

public class SimpleHibernateMapping {
    public static void main(String[] args) { 
        SessionFactory sessionFactory = HibernateUtil.createSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person p = new Person("Peter", "Palm", 35);
        session.save(p);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
