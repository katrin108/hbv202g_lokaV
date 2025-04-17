package is.hi.kas108.hbv202g.assignment11;


import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class LendingTest {
    private Lending testLending;

    private Book book;

    private Student student;
    @Before
    public void setUp()  {
        book = new Book("Title","Author");
        student = new Student("Name",true);
        testLending = new Lending(book, student);


    }
    @Test

    public void testGetDueDate() {
        LocalDate dueDate = LocalDate.now().plusDays(30);
        assertEquals(dueDate, testLending.getDueDate(dueDate));
    }
    @Test

    public void testSetDueDate() {
        LocalDate dueDate = LocalDate.now().plusDays(100);
        testLending.setDueDate(dueDate);
        assertEquals(dueDate, testLending.getDueDate(dueDate));
    }
@Test
    public void testGetBook() {
        assertEquals(book, testLending.getBook());

    }
@Test
    public void testSetBook() {
        book = new Book("Title2","Author2");
        testLending.setBook(book);
        assertEquals(book, testLending.getBook());
    }
@Test
    public void testGetUser() {
        assertEquals(student, testLending.getUser());
    }
@Test
    public void testSetUser() {
        student = new Student("Name2",true);
        testLending.setUser(student);
        assertEquals(student, testLending.getUser());
    }
}