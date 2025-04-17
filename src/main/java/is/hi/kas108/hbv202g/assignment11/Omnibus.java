package is.hi.kas108.hbv202g.assignment11;

import java.util.ArrayList;
import java.util.List;

public class Omnibus extends LibraryItem {
    private List<LibraryItem> items = new ArrayList<>();

    public Omnibus(String title) {
        super(title);
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    @Override
    public void borrow(User user, List<Lending> lendings) {
        for (LibraryItem item : items) {
            item.borrow(user, lendings); // delegate to children
        }
    }

    public List<LibraryItem> getItems() {
        return items;
    }


}

