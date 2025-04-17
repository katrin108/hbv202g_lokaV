package is.hi.kas108.hbv202g.assignment11;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AuthorTest {

    private Author testAuthor;
    private String name;
    @Before
    public void createAuthor(){

        name="Anna";
        testAuthor=new Author(name);

    }

    @Test
    public void testGetName() {

        assertNotNull(testAuthor);

        assertEquals(name,testAuthor.getName());
    }
    @Test

    public void testSetName() {
        assertNotNull(testAuthor);
        String name="Bob";
        testAuthor.setName(name);
        assertEquals(name,testAuthor.getName());
    }
}