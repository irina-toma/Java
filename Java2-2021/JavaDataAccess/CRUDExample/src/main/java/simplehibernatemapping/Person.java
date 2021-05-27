package simplehibernatemapping;

public class Person {
 
    private int id;
    private String firstName;
    private int age;
    private String lastName;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }
 
    public Person() {
    }
}