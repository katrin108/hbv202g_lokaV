package is.hi.kas108.hbv202g.assignment11;

import java.util.ArrayList;
import java.util.List;

public class Book extends LibraryItem {
    private List<Author> authors;

    public Book(String title, Author author) throws EmptyAuthorListException {
        super(title);
        if (author == null) {
            throw new EmptyAuthorListException("The book has no authors");
        }

        this.authors = new ArrayList<>();
        this.authors.add(author);
    }

    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        super(title);
        if (authors.isEmpty()) {
            throw new EmptyAuthorListException("The book has no authors");
        }
        this.authors = new ArrayList<>(authors);
    }

    @Override
    public void borrow(User user, List<Lending> lendings) {
        lendings.add(new Lending(this, user));
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()) {
            throw new EmptyAuthorListException("The book has no authors");
        }
        this.authors = new ArrayList<>(authors);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }


}
