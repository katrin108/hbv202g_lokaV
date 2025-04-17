package is.hi.kas108.hbv202g.assignment11;

/**
 * Exception thrown when either the user or the item
 * does not exist in the library system
 */
public class UserOrBookDoesNotExistException extends Exception {
    /**
     * Constructs a new UserOrBookDoesNotExistException with the specified detail message
     * @param message The detail message explaining the reason for the exception
     */
    public UserOrBookDoesNotExistException(String message) {
        super(message);

    }
}
