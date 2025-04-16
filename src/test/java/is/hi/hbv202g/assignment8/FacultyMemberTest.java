package is.hi.hbv202g.assignment8;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class FacultyMemberTest extends TestCase {
    private FacultyMember facultyMember;

    private String department;
    private String name;
    @Before
    public void setUp(){
        department = "Computer Science";
        name = "Bob";
        facultyMember = new FacultyMember(name, department);
    }
    @Test
    public void testGetDepartment() {
        assertEquals(name, facultyMember.getName());
        assertEquals(department, facultyMember.getDepartment());
    }
    @Test
    public void testSetDepartment() {
        String newDepartment = "Mathematics";
        facultyMember.setDepartment(newDepartment);
        assertEquals(newDepartment, facultyMember.getDepartment());
    }
}