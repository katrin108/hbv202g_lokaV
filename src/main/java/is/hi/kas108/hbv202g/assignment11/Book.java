package is.hi.kas108.hbv202g.assignment11;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents a book in the library system.
 * A book has a title and one or more authors.
 * Inherits from {@link LibraryItem}.
 */
public class Book extends LibraryItem {
    private List<Author> authors;
    /**
     * Constructs a Book with a single author.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     * @throws EmptyAuthorListException if the author is null.
     */
    public Book(String title, Author author) throws EmptyAuthorListException {
        super(title);
        if (author == null) {
            throw new EmptyAuthorListException("The book has no authors");
        }

        this.authors = new ArrayList<>();
        this.authors.add(author);
    }
    /**
     * Constructs a Book with a many authors.
     *
     * @param title  The title of the book.
     * @param authors The authors of the book.
     * @throws EmptyAuthorListException if the author is null.
     */
    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        super(title);
        if (authors.isEmpty()) {
            throw new EmptyAuthorListException("The book has no authors");
        }
        this.authors = new ArrayList<>(authors);
    }
    /**
     * Borrows the book for a given user and adds it to the lending list.
     * @param user     The user borrowing the book.
     * @param lendings The list of current lendings.
     */
    @Override
    public void borrow(User user, List<Lending> lendings) {
        lendings.add(new Lending(this, user));
    }

    /**
     * Returns the list of authors of the book.
     * @return The authors.
     */
    public List<Author> getAuthors() {
        return authors;
    }
    /**
     * Sets the list of authors for the book.
     * @param authors The new list of authors.
     * @throws EmptyAuthorListException if the list is empty.
     */
    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()) {
            throw new EmptyAuthorListException("The book has no authors");
        }
        this.authors = new ArrayList<>(authors);
    }
    /**
     * Adds a new author to the book.
     * @param author The author to be added.
     */
    public void addAuthor(Author author) {
        this.authors.add(author);
    }


}
