package is.hi.kas108.hbv202g.assignment11;
/**
 * Implements the LibraryObserver interface
 * This class logs messages whenever it receives an update from the LibrarySystem
 */
public class LibraryLogger implements LibraryObserver {
    /**
     *
     * Updates the logger with a new message
     *
     * This method prints the message prefixed with "[LOG]"
     *
     * @param message The message to be logged
     */
    @Override
    public void update(String message) {
        System.out.println("[LOG]: " + message);
    }
}