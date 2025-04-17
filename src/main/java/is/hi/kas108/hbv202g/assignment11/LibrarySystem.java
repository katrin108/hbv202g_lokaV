package is.hi.kas108.hbv202g.assignment11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * The main class responsible for managing the library system
 * It handles the addition of library items, users, borrowing, returning, and lending books
 */
public class LibrarySystem {

    private List<LibraryItem> libraryItems;

    private List<User> users;

    private List<Lending> lendings;

    private List<LibraryObserver> observers;

    /**
     * Constructs a LibrarySystem instance and initializes the lists for library items,
     * users, lendings, and observers
     */
    public LibrarySystem() {
        this.libraryItems = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /**
     * Adds an observer to the system. Observers are notified when certain events occur
     * @param observer The observer to be added
     */
    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }
    /**
     * Notifies all registered observers about an event by sending a message
     * @param message The message to be sent to the observers
     */
    private void notifyObservers(String message) {
        for (LibraryObserver observer : observers) {
            observer.update(message);
        }
    }

    /**
     * Adds a library item with a single author to the system
     * @param title The title of the book
     * @param authorName The name of the author
     * @throws EmptyAuthorListException if the author name is empty or invalid
     */
    public void addLibraryItemWithTitleAndNameOfSingleAuthor(String title, String authorName) throws EmptyAuthorListException {
        if(authorName.isEmpty()|| authorName.trim().isEmpty()) throw new EmptyAuthorListException("the book has no author");
        Author author = new Author(authorName);
        libraryItems.add(new Book(title, author));
    }

    /**
     * Adds a library item with multiple authors to the system.
     * @param title The title of the book
     * @param authors The list of authors
     * @throws EmptyAuthorListException if the list of authors is empty
     */
    public void addLibraryItemWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException  {
        if(authors.isEmpty()) throw new EmptyAuthorListException("the book has no authors");
        libraryItems.add(new Book(title, authors));
    }
    /**
     * Adds a student user to the system
     * @param name The name of the student
     * @param feePaid Indicates whether the student has paid their fees
     */
    public void addStudentUser(String name, boolean feePaid) {
        users.add(new Student(name, feePaid));
    }
    /**
     * Adds a faculty member user to the system
     * @param name The name of the faculty member
     * @param department The department of the faculty member
     */
    public void addFacultyMemberUser(String name, String department) {
        users.add(new FacultyMember(name, department));
    }

    /**
     * Finds a book by its title
     * @param title The title of the book
     * @return The book if found, otherwise null
     * @throws UserOrBookDoesNotExistException if the book is not found
     */
    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        return (Book) libraryItems.stream().filter(libraryItem -> libraryItem.getTitle().equals(title)).findFirst().orElse(null);
    }

    /**
     * Finds a user by their name
     * @param name The name of the user
     * @return The user if found
     * @throws UserOrBookDoesNotExistException if the user is not found
     */
    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        if (users.stream().noneMatch(user -> user.getName().equals(name))) throw new UserOrBookDoesNotExistException("User " + name + " not found");
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }
    /**
     * Allows a user to borrow an item from the library
     * Notifies observers after the borrowing action
     * @param user The user borrowing the item
     * @param item The library item being borrowed
     * @throws UserOrBookDoesNotExistException if the user or item does not exist
     */
    public void borrowItem(User user, LibraryItem item) throws UserOrBookDoesNotExistException {
        if (findUserByName(user.getName()) == null || item == null) {
            throw new UserOrBookDoesNotExistException("User or item does not exist");
        }
        item.borrow(user, lendings); // Composite pattern in action
        notifyObservers(user.getName() + " borrowed: " + item.getTitle());
    }

    /**
     * Retrieves the list of lendings currently in the system
     * @return The list of lendings
     */
    public List<Lending> getLendings() {
        return lendings;
    }

    /**
     * Extends the due date for a book borrowed by a faculty member
     * @param facultyMember The faculty member requesting the extension
     * @param book The book for which the lending period is being extended
     * @param newDueDate The new due date
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException {
       if (findUserByName(facultyMember.getName())==null || findBookByTitle(book.getTitle())==null) {
           throw new UserOrBookDoesNotExistException("User or book does not exist");
       }
       lendings.stream().filter(lending -> lending.getBook().equals(book)).findFirst().ifPresent(lending -> lending.setDueDate(newDueDate));

    }

    /**
     * Allows a user to return a book
     * @param user The user returning the book
     * @param book The book being returned
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */

    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if (findUserByName(user.getName())==null || findBookByTitle(book.getTitle())==null) {
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }
        lendings.removeIf(lending -> lending.getBook().equals(book) && lending.getUser().equals(user));
    }


}
