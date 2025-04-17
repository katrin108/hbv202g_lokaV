package is.hi.kas108.hbv202g.assignment11;

import java.time.LocalDate;
/**
 * Represents a lending of a book to a user in the library system
 * Each lending has a due date, associated book, and the user who borrowed it
 */
public class Lending {
    private LocalDate dueDate;

    private Book book;
    private User user;
    /**
     * Constructs a new Lending with the specified book and user
     * The due date is set to 30 days from the current date
     * @param book The book being borrowed
     * @param user The user borrowing the book
     */
    public Lending(Book book, User user) {
        this.book = book;
        this.user = user;
        this.dueDate = LocalDate.now().plusDays(30);
    }

    /**
     * Gets the due date of the lending
     * @return The due date of the lending
     */

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    /**
     *
     * Sets the due date of the lending
     * @param dueDate The new due date for the lending
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the book being borrowed in this lending
     * @return The borrowed book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the book to be borrowed in this lending
     * @param book The book being borrowed
     */
    public void setBook(Book book) {
        this.book = book;
    }
    /**
     * Gets the user who borrowed the book in this lending
     * @return The user who borrowed the book
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * Sets the user who borrowed the book in this lending
     * @param user The user borrowing the book
     */
    public void setUser(User user) {
        this.user = user;
    }
}
