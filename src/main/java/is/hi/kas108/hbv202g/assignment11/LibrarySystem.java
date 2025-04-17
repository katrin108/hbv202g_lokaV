package is.hi.kas108.hbv202g.assignment11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private List<LibraryItem> libraryItems;

    private List<User> users;

    private List<Lending> lendings;

    private List<LibraryObserver> observers;
    public LibrarySystem() {
        this.libraryItems = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
        this.observers = new ArrayList<>();
    }


    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (LibraryObserver observer : observers) {
            observer.update(message);
        }
    }


    public void addLibraryItemWithTitleAndNameOfSingleAuthor(String title, String authorName) throws EmptyAuthorListException {
        if(authorName.isEmpty()|| authorName.trim().isEmpty()) throw new EmptyAuthorListException("the book has no author");
        Author author = new Author(authorName);
        libraryItems.add(new Book(title, author));
    }
    public void addLibraryItemWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException  {
        if(authors.isEmpty()) throw new EmptyAuthorListException("the book has no authors");
        libraryItems.add(new Book(title, authors));
    }

    public void addStudentUser(String name, boolean feePaid) {
        users.add(new Student(name, feePaid));
    }
    public void addFacultyMemberUser(String name, String department) {
        users.add(new FacultyMember(name, department));
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        return (Book) libraryItems.stream().filter(libraryItem -> libraryItem.getTitle().equals(title)).findFirst().orElse(null);
    }


    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        if (users.stream().noneMatch(user -> user.getName().equals(name))) throw new UserOrBookDoesNotExistException("User " + name + " not found");
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    public void borrowItem(User user, LibraryItem item) throws UserOrBookDoesNotExistException {
        if (findUserByName(user.getName()) == null || item == null) {
            throw new UserOrBookDoesNotExistException("User or item does not exist");
        }
        item.borrow(user, lendings); // Composite pattern in action
        notifyObservers(user.getName() + " borrowed: " + item.getTitle());
    }

    public List<Lending> getLendings() {
        return lendings;
    }

    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException {
       if (findUserByName(facultyMember.getName())==null || findBookByTitle(book.getTitle())==null) {
           throw new UserOrBookDoesNotExistException("User or book does not exist");
       }
       lendings.stream().filter(lending -> lending.getBook().equals(book)).findFirst().ifPresent(lending -> lending.setDueDate(newDueDate));

    }

    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if (findUserByName(user.getName())==null || findBookByTitle(book.getTitle())==null) {
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }
        lendings.removeIf(lending -> lending.getBook().equals(book) && lending.getUser().equals(user));
    }


}
