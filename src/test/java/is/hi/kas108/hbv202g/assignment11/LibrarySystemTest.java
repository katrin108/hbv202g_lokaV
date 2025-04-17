package is.hi.kas108.hbv202g.assignment11;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibrarySystemTest {

    private LibrarySystem librarySystem;

    @Before
    public void setUp()  {
        librarySystem = new LibrarySystem();


    }


    @Test

    public void testAddBookWithTitleAndNameOfSingleAuthor() throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Koko's Adventure", "Koko");
        Book book = librarySystem.findBookByTitle("Koko's Adventure");
        assertEquals("Koko's Adventure", book.getTitle());

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
@Test
    public void testFindBookByTitle() throws EmptyAuthorListException, UserOrBookDoesNotExistException {

        librarySystem.addBookWithTitleAndNameOfSingleAuthor("1984","George Orwell");

        Book book = librarySystem.findBookByTitle("1984");

        assertNotNull(book);


        assertEquals(book, librarySystem.findBookByTitle(book.getTitle()));



    }
    @Test

    public void testFindUserByName() throws UserOrBookDoesNotExistException {
        librarySystem.addStudentUser("Olafur", true);

        User user = librarySystem.findUserByName("Olafur");

        assertNotNull(user);

        assertEquals(user, librarySystem.findUserByName(user.getName()));
    }
@Test
    public void testborrowItem() throws UserOrBookDoesNotExistException , EmptyAuthorListException {

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addStudentUser("ABC", true);
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("1984","George Orwell");


        librarySystem.borrowItem(librarySystem.findUserByName("ABC"), librarySystem.findBookByTitle("1984"));

        assertEquals(1, librarySystem.getLendings().size());


    }
    @Test

    public void testExtendLending() throws UserOrBookDoesNotExistException, EmptyAuthorListException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addStudentUser("ABC", true);
        librarySystem.addFacultyMemberUser("DEF", "Computer Science");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("1984","George Orwell");

        librarySystem.borrowItem(librarySystem.findUserByName("ABC"), librarySystem.findBookByTitle("1984"));

        User facultyMember = librarySystem.findUserByName("DEF");
        Book book = librarySystem.findBookByTitle("1984");

        LocalDate date = LocalDate.of(2025, 11, 1);

        librarySystem.extendLending((FacultyMember) facultyMember , book,date);
        Lending lending = librarySystem.getLendings().getFirst();

        assertEquals(date, lending.getDueDate());


    }
    @Test

    public void testReturnBook() throws UserOrBookDoesNotExistException, EmptyAuthorListException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addStudentUser("ABC", true);
        librarySystem.addFacultyMemberUser("DEF", "Computer Science");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("1984","George Orwell");

        librarySystem.borrowItem(librarySystem.findUserByName("ABC"), librarySystem.findBookByTitle("1984"));
        User user = librarySystem.findUserByName("ABC");
        Book book = librarySystem.findBookByTitle("1984");
        librarySystem.returnBook(user, book);

        assertEquals(0, librarySystem.getLendings().size());

    }
}