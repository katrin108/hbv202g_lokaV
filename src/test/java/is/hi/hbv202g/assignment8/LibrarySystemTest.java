package is.hi.hbv202g.assignment8;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystemTest extends TestCase {

    private LibrarySystem librarySystem;

    @Before
    public void setUp()  {
        librarySystem = new LibrarySystem();


    }
    @Test

    public void testAddBookWithTitleAndNameOfSingleAuthor() throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Koko's Adventure", "Koko");
        Book book = librarySystem.findBookByTitle("Koko's Adventure");
        assertEquals("Koko´s Adventure", book.getTitle());

        assertEquals("Koko", book.getAuthors().get(0).getName());

    }
    @Test

    public void testAddBookWithTitleAndAuthorList() throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        Author author1 = new Author("Terry Pratchett");
        Author author2 = new Author("Neil Gaiman");
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        librarySystem.addBookWithTitleAndAuthorList("Good Omens", authors);
        Book book = librarySystem.findBookByTitle("Good Omens");
        assertEquals("Good Omens", book.getTitle());

        assertEquals("Terry Pratchett", book.getAuthors().get(0).getName());
    }
    @Test

    public void testAddStudentUser() throws UserOrBookDoesNotExistException {
        librarySystem.addStudentUser("Ari", true);
        User user = librarySystem.findUserByName("Ari");
        assertTrue(user instanceof Student);

        Student studentUser = (Student) user;

        assertEquals("Ari", studentUser.getName());
        assertTrue(studentUser.isFeePaid());

    }
    @Test

    public void testAddFacultyMemberUser() throws UserOrBookDoesNotExistException {
        librarySystem.addFacultyMemberUser("Anna", "Computer Science");
        User user = librarySystem.findUserByName("Anna");
        assertTrue(user instanceof FacultyMember);
        FacultyMember facultyMember = (FacultyMember) user;
        assertEquals("Anna", facultyMember.getName());
        assertEquals("Computer Science", facultyMember.getDepartment());


    }

    public void testFindBookByTitle() throws EmptyAuthorListException, UserOrBookDoesNotExistException {

        librarySystem.addBookWithTitleAndNameOfSingleAuthor("1984","George Orwell");

        Book book = librarySystem.findBookByTitle("1984");

        assertNotNull(book);


        assertEquals(book, librarySystem.findBookByTitle(book.getTitle()));



    }

    public void testFindUserByName() throws UserOrBookDoesNotExistException {
        librarySystem.addStudentUser("Olafur", true);

        User user = librarySystem.findUserByName("Olafur");

        assertNotNull(user);

        assertEquals(user, librarySystem.findUserByName(user.getName()));
    }

    public void testBorrowBook() throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Hobbit", "J.R.R. Tolkien");
        librarySystem.addStudentUser("Peter", true);
        Book book = librarySystem.findBookByTitle("Hobbit");
        User user = librarySystem.findUserByName("Peter");
        librarySystem.borrowBook(user, book);

        assertNotNull(book);
        assertNotNull(user);


    }

    public void testExtendLending() {
    }

    public void testReturnBook() {
    }
}