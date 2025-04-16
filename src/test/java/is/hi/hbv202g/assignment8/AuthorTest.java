package is.hi.hbv202g.assignment8;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest extends TestCase {

    private Author testAuthor;
    private String name;
    @Before
    public void createAuthor(){
        testAuthor=new Author("Anna");
        name="Anna";
    }

    @Test
    public void testGetName() {
        assertEquals(name,testAuthor.getName());
    }
    @Test

    public void testSetName() {
        String name="Bob";
        testAuthor.setName(name);
        assertEquals(name,testAuthor.getName());
    }
}