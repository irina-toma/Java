import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroupTest {
    @DisplayName("Creates a new group")
    @Test
    public void createGroup() {
        Group g = new Group("family");
        assertEquals(g.getType(), "family");
    }

    @DisplayName("Verifies person is added to group")
    @Test
    public void addToGroup() {
        Person p = new Person("X", 10, false);
        Group g = new Group("family");
        g.addMember(p);
        assertSame(p, g.getMembers().get(0));
    }

    @DisplayName("Verifies priority of group with small child")
    @Test
    public void prioritySmallChild() {
        Person p = new Person("X", 1, false);
        Group g = new Group("family");
        g.addMember(p);

        assertEquals(1, g.getPriority());
    }
}
