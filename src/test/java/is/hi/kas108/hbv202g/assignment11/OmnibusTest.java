package is.hi.kas108.hbv202g.assignment11;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OmnibusTest {
    @Test

    public void testAddItem() throws EmptyAuthorListException {
        LibraryItem item = new Book("Book", new Author("Author"));
        Omnibus omnibus = new Omnibus("Omnibus");
        omnibus.addItem(item);
        assertEquals(1, omnibus.getItems().size());
    }


}