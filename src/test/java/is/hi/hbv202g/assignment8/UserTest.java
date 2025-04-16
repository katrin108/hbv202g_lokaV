package is.hi.hbv202g.assignment8;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class UserTest extends TestCase {
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