package is.hi.kas108.hbv202g.assignment11;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class UserTest {
    FacultyMember facultyMember;
    String name;

    @Before
    public void setUp()  {
        name = "Anna";
        facultyMember = new FacultyMember(name, "Computer Science");

    }


    @Test
    public void testGetName() {
        assertEquals(name, facultyMember.getName());

    }
    @Test

    public void testSetName() {
        String newName = "Bob";
        facultyMember.setName(newName);
        assertEquals(newName, facultyMember.getName());
    }
}