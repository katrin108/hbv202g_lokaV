package is.hi.kas108.hbv202g.assignment11;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FacultyMemberTest {
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