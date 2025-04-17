package is.hi.kas108.hbv202g.assignment11;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents an omnibus, which is a collection of multiple library items
 * Implements the Composite design pattern by treating a group of items as a single item
 */
public class Omnibus extends LibraryItem {
    private List<LibraryItem> items = new ArrayList<>();

    /**
     * Constructs an Omnibus with the specified title
     * @param title The title of the omnibus
     */
    public Omnibus(String title) {
        super(title);
    }
    /**
     * Adds a library item to the omnibus collection
     * @param item The LibraryItem to be added
     */
    public void addItem(LibraryItem item) {
        items.add(item);
    }
    /**
     * Borrows the omnibus, which results in borrowing all contained items
     * This method delegates the borrowing to each item in the omnibus
     * @param user The user who is borrowing the omnibus
     * @param lendings The list of active lendings to which borrowed items are added
     */
    @Override
    public void borrow(User user, List<Lending> lendings) {
        for (LibraryItem item : items) {
            item.borrow(user, lendings); // delegate to children
        }
    }
    /**
     * Returns the list of items contained in the omnibus
     * @return The list of LibraryItems in this omnibus
     */
    public List<LibraryItem> getItems() {
        return items;
    }


}

