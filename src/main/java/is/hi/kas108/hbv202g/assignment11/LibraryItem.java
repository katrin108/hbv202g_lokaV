package is.hi.kas108.hbv202g.assignment11;

import java.util.List;
/**
 *
 *
 * Represents an item in the library system
 * A library item could be a book, Omnibus, or other types of items
 * Each item has a title and can be borrowed by a user
 */
public abstract class LibraryItem {
    protected String title;
    /**
     * Constructs a LibraryItem with the specified title
     * @param title The title of the library item
     */
    public LibraryItem(String title) {
        this.title = title;
    }
    /**
     * Gets the title of the library item
     * @return The title of the item
     */
    public String getTitle() {
        return title;
    }

    /**
     * Abstract method to be implemented by subclasses to handle borrowing of the item
     * @param user The user who is borrowing the item
     * @param lendings The list of lendings to update
     */

    public abstract void borrow(User user, List<Lending> lendings);
}
