package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private List<Book> books;

    private List<User> users;

    private List<Lending> lendings;

    public LibrarySystem() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        lendings = new ArrayList<>();
    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) throws EmptyAuthorListException {
        if(authorName.isEmpty()|| authorName.trim().isEmpty()){
            throw new EmptyAuthorListException("Author name cannot be empty ");
        }
        books.add(new Book(title, authorName));
    }
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException {
        if (authors == null || authors.isEmpty()) {
            throw new EmptyAuthorListException("Author list is empty");
        }
        books.add(new Book(title, authors));
    }

    public void addStudentUser(String name, boolean feePaid) {
        users.add(new Student(name, feePaid));
    }
    public void addFacultyMemberUser(String name, String department) {
        users.add(new FacultyMember(name, department));
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new UserOrBookDoesNotExistException("Book " + title + " not found"));
    }


    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElseThrow(() -> new UserOrBookDoesNotExistException("User " + name + " not found"));
    }

    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException{
        if (findBookByTitle(book.getTitle()) == null || findUserByName(user.getName()) == null) {
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }else{
            lendings.add(new Lending(book, user));
        }

    }
   public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
       lendings.stream().filter(lending -> lending.getBook().equals(book) && lending.getUser().equals(facultyMember)).findFirst().ifPresent(lending -> lending.setDueDate(newDueDate));
   }

    public void returnBook(User user, Book book) {
        lendings.removeIf(lending -> lending.getBook().equals(book) && lending.getUser().equals(user));
    }


}
