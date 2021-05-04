public class Person extends Tourist {
    private String name;
    private int age;
    private boolean disability;

    public Person(String name, int age, boolean disability) {
        this.name = name;
        this.age = age;
        this.disability = disability;
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

    public boolean isDisability() {
        return disability;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;
    }

    public int getPriority() {
        if (this.disability) {
            return 0;
        }
        if (this.getAge() <= 2 ) {
            return 1;
        }
        if (this.getAge() >= 70) {
            return 2;
        }
        return 4;
    }

    @Override
    public String toString() {
        return "Individual - " + this.name + " Priority - " + this.getPriority();
    }
}
