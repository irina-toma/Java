import java.util.ArrayList;

public class Group extends Tourist {
    private String type;
    private ArrayList<Person> members;

    public Group(String type) {
        this.type = type;
        this.members = new ArrayList<Person>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Person> members) {
        this.members = members;
    }

    public void addMember(Person p) {
        this.members.add(p);
    }

    public int getPriority() {
        if (this.type.equals("disability")) {
            return 0;
        }
        if (this.type.equals("family")) {
            for (Person p : this.members) {
                if (p.getAge() <= 2 ) {
                    return 1;
                }
                if (p.getAge() >= 70) {
                    return 2;
                }
            }
        }
        return 3;
    }

    @Override
    public String toString() {
        return "Group - " + this.type + " Priority - " + this.getPriority() + " Members - " + this.members;
    }
}
