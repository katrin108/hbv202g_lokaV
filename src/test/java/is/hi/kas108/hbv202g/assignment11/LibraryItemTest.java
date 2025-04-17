package is.hi.kas108.hbv202g.assignment11;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class LibraryItemTest extends TestCase {
   @Test

    public void testGetTitle() throws EmptyAuthorListException {
       Book book = new Book("Title",new Author("Author"));
        assertEquals("Title", book.getTitle());
    }

    @Test

    public void testBorrow() throws EmptyAuthorListException {
       Book book = new Book("Title",new Author("Author"));
       Student student = new Student("Name",true);
       Lending lending = new Lending(book, student);
       assertEquals(book, lending.getBook());
       assertEquals(student, lending.getUser());
    }

}