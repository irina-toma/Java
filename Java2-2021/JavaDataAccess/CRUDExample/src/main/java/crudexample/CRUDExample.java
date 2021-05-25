package crudexample;

import model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class CRUDExample {
	public static void main(String[] args) {
		Session session = HibernateUtil.createSessionFactory().openSession();
		Person person = new Person("John", "Maverick", 22);

		session.save(person);
		System.out.println("Object stored in DB.\nObject info:\nPerson id: " + person.getId() + "\nPerson name: "
				+ person.getFirstname() + " " + person.getLastname());

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Person retreivedPerson = (Person) session.get(Person.class, 1);

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
