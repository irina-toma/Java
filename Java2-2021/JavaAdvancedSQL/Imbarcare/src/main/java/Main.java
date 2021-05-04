import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Tourist> passengers = new ArrayList<Tourist>();
        passengers.add(new Person("A", 12, true));
        passengers.add(new Person("B", 27, false));
        passengers.add(new Person("C", 78, false));

        Group g1 = new Group("family");
        g1.addMember(new Person("F1", 30, false));
        g1.addMember(new Person("F2", 1, false));

        Group g2 = new Group("disability");
        g2.addMember(new Person("D1", 45, true));
        g2.addMember(new Person("D2", 39, false));

        passengers.add(g1);
        passengers.add(g2);

        Collections.sort(passengers);

        System.out.println(passengers);

    }
}
