package crudexample;

import model.Person2;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import utils.HibernateUtils5;

public class CRUDExample {
	public static void main(String[] args) {
		Session session = HibernateUtils5.createSessionFactory().openSession();
		Person2 person = new Person2("John", "Maverick", 22);

		session.save(person);
		System.out.println("Object stored in DB.\nObject info:\nPerson id: " + person.getId() + "\nPerson name: "
				+ person.getFirstname() + " " + person.getLastname());

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Person2 retreivedPerson = (Person2) session.get(Person2.class, person.getId());

			System.out.println("Retrieved object.\nObject info:\nPerson id: " + retreivedPerson.getId()
					+ "\nPerson name: " + retreivedPerson.getFirstname() + " " + retreivedPerson.getLastname());

			retreivedPerson.setFirstname("Mike");
			session.update(retreivedPerson);

//			 session.delete(retreivedPerson);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e);
		} finally {
			session.close();
		}
	}
}
