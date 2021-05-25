package simpleactiverecord;

import java.sql.SQLException;
import java.util.List;

public class SimpleActiveRecord {
	public static void main(String[] args) throws SQLException {
		Person newPerson = new Person();
		newPerson.firstname = "Sally";
		newPerson.lastname = "Jones";
		newPerson.age = 30;
		newPerson.insert();
		List<Person> persons = Person.getAll();
		for (Person p : persons) {
			System.out.println(p);
		}
		Person updated = Person.getById(3);
		if (updated != null) {
			updated.firstname = "John";
			updated.lastname = "Smith";
			updated.update();
		}
		persons = Person.getAll();
		for (Person p : persons) {
			System.out.println(p);
		}
	}
}
