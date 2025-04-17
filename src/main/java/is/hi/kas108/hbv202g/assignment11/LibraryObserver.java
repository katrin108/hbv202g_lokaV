package is.hi.kas108.hbv202g.assignment11;
/**
 * Represents an observer in the library system
 * Observers are notified when there is an update in the library system, such as when a book is borrowed
 */
public interface LibraryObserver {

    /**
     * Called when an update occurs in the library system
     * Implementing classes should define what happens when they receive this update
     * @param message The message detailing the update
     */
    void update(String message);
}
