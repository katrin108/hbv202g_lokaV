package is.hi.kas108.hbv202g.assignment11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private List<Book> books;

    private List<User> users;

    private List<Lending> lendings;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) throws EmptyAuthorListException {
        if(authorName.isEmpty()|| authorName.trim().isEmpty()) throw new EmptyAuthorListException("the book has no author");
        books.add(new Book(title, authorName));
    }
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException  {
        if(authors.isEmpty()) throw new EmptyAuthorListException("the book has no authors");
        books.add(new Book(title, authors));
    }

    public void addStudentUser(String name, boolean feePaid) {
        users.add(new Student(name, feePaid));
    }
    public void addFacultyMemberUser(String name, String department) {
        users.add(new FacultyMember(name, department));
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElseThrow(()-> new UserOrBookDoesNotExistException("Book " + title + " not found"));
    }


    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        if (users.stream().noneMatch(user -> user.getName().equals(name))) throw new UserOrBookDoesNotExistException("User " + name + " not found");
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if (findUserByName(user.getName())==null || findBookByTitle(book.getTitle())==null) {
           throw new UserOrBookDoesNotExistException("User or book does not exist");
        }
        lendings.add(new Lending(book, user));

    }
   public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException {
       if (findUserByName(facultyMember.getName())==null || findBookByTitle(book.getTitle())==null) {
           throw new UserOrBookDoesNotExistException("User or book does not exist");
       }
       lendings.stream().filter(lending -> lending.getBook().equals(book) && lending.getUser().equals(facultyMember)).findFirst().ifPresent(lending -> lending.setDueDate(newDueDate));
   }

    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if (findUserByName(user.getName())==null || findBookByTitle(book.getTitle())==null) {
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }
        lendings.removeIf(lending -> lending.getBook().equals(book) && lending.getUser().equals(user));
    }


}
