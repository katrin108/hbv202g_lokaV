package is.hi.kas108.hbv202g.assignment11;
/**
 * Abstract class representing a user of the library system
 * A user has a name and can be extended by specific types of users
 * such as students or faculty members
 */
public abstract class User {
    private String name;
    /**
     * Constructs a User with the given name
     * @param name The name of the user
     */
    public User(String name) {
        this.name = name;
    }
    /**
     * Gets the name of the user
     * @return The user's name
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the user
     * @param name The new name for the user
     */

    public void setName(String name) {
        this.name = name;
    }
}
