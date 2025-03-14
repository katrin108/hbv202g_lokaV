package is.hi.hbv202g.assignment8;

import java.util.List;

public class Book {
    private String title;

    private List<Author> authors;

    public Book(String title, String authorName) {
        setTitle(title);
        setAuthors(List.of(new Author(authorName)));
    }

    public Book(String title, List<Author> authors) {
        setTitle(title);
        setAuthors(authors);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        try {
            if (authors == null || authors.isEmpty()) {
                throw new EmptyAuthorListException("Author list is empty");
            }else {
                this.authors = authors;
            }
        } catch (EmptyAuthorListException e) {
            e.printStackTrace();
        }

    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
