package is.hi.kas108.hbv202g.assignment11;
/**
 * Exception thrown when an attempt is made to create a book with an empty list of authors.
 */
public class EmptyAuthorListException extends Exception{
    /**
     * Constructs a new EmptyAuthorListExceptio with the specified detail message.
     * @param message Message explaining the exception.
     */
    public EmptyAuthorListException(String message) {
        super(message);
    }

}
