package is.hi.kas108.hbv202g.assignment11;
/**
 * Represents a faculty member in the library system
 * A faculty member is a type of user who belongs to a department
 */
public class FacultyMember extends User{
    private String department;
    /**
     * Constructs a FacultyMember with the specified name and department
     * @param name       name of the faculty member
     * @param department department the faculty member belongs to
     */
    public FacultyMember(String name, String department) {
        super(name);
        this.department = department;
    }
    /**
     * Gets the department of the faculty member
     * @return The department of the faculty member
     */
    public String getDepartment() {
        return department;
    }
    /**
     * Sets the department of the faculty member
     * @param department The new department for the faculty member
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
