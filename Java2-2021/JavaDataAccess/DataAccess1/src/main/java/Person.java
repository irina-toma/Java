import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private String pid;

    public Person() {
    }

    public Person(String name, int age, String pid) {
        this.name = name;
        this.age = age;
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return name + ";" + age + ";" + pid;
    }
}
