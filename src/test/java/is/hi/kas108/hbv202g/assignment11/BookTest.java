package is.hi.kas108.hbv202g.assignment11;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookTest {
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
        authors=new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        //set up book
        title="Title";
        book=new Book(title,authors);

    }
    @Test
    public void testBorrow() {
        User user=new Student("Siggi",true);
        ArrayList<Lending> lendings=new ArrayList<>();
        book.borrow(user,lendings);
        assertEquals(1,lendings.size());
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



}