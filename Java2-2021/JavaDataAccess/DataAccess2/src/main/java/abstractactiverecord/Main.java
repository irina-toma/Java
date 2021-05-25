package abstractactiverecord; 
import java.sql.SQLException; 

import java.util.List;
public class Main {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SQLException, NoSuchFieldException, InstantiationException {
       Person p = new Person();
       p.firstname = "Peter";
       p.lastname = "Jackson";
       p.age = 35;
       p.insert();
       
       Person p1 = new Person();
       p.getById(p.id);
       p.firstname = "Sally";
       p.lastname = "Jones";
       p.update();
       
       Person u = new Person();
       List<Person> persons = u.getAll();
       persons.stream().forEach((prs) -> {
           System.out.println(prs);
        }); 
    }
}
