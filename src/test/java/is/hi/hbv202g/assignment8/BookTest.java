package is.hi.hbv202g.assignment8;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BookTest extends TestCase {
    private Author author1;
    private Author author2;
    private Author author3;

    private Book book;

    private List<Author> authors;

    private String title;

    @Before
    public void setUp() throws EmptyAuthorListException {
        //create authors
        author1=new Author("Anna");
        author2=new Author("Bob");
        author3=new Author("Tom");

        //create list of authors
        authors=new ArrayList<Author>();
        authors.add(author1);
        authors.add(author2);

        //set up book
        title="Title";
        book=new Book(title,authors);

    }
    @Test

    public void testGetAuthors() {
        assertEquals(book.getAuthors(),authors);
    }
    @Test

    public void testSetAuthors() throws EmptyAuthorListException {
        ArrayList<Author> NewAuthors=new ArrayList<>();
        NewAuthors.add(new Author("Siggi"));
        NewAuthors.add(new Author("Eirik"));

        book.setAuthors(NewAuthors);
        assertEquals(NewAuthors,book.getAuthors());

    }
    @Test
    public void testAddAuthor() {
        book.addAuthor(author3);
        authors.add(author3);
        assertEquals(authors,book.getAuthors());
    }

   @Test
    public void testGetTitle() {
        assertEquals(title,book.getTitle());

    }
    @Test
    public void testSetTitle() {
        String newTitle="New Title";
        book.setTitle(newTitle);
        assertEquals(newTitle,book.getTitle());
    }

    @Test
    public void tetsSetAthorsThrowsException() throws EmptyAuthorListException {
        book.setAuthors(new ArrayList<Author>());
    }
}