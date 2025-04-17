package is.hi.kas108.hbv202g.assignment11;

import java.util.List;

public abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void borrow(User user, List<Lending> lendings);
}
