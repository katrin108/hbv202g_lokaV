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

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName)  {

        books.add(new Book(title, authorName));
    }
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors)  {

        books.add(new Book(title, authors));
    }

    public void addStudentUser(String name, boolean feePaid) {
        users.add(new Student(name, feePaid));
    }
    public void addFacultyMemberUser(String name, String department) {
        users.add(new FacultyMember(name, department));
    }

    public Book findBookByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }


    public User findUserByName(String name)  {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    public void borrowBook(User user, Book book) {

            lendings.add(new Lending(book, user));


    }
   public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
       lendings.stream().filter(lending -> lending.getBook().equals(book) && lending.getUser().equals(facultyMember)).findFirst().ifPresent(lending -> lending.setDueDate(newDueDate));
   }

    public void returnBook(User user, Book book) {
        lendings.removeIf(lending -> lending.getBook().equals(book) && lending.getUser().equals(user));
    }


}
