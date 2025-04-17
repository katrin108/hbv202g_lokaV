package is.hi.kas108.hbv202g.assignment11;

public class LibraryLogger implements LibraryObserver {
    @Override
    public void update(String message) {
        System.out.println("[LOG]: " + message);
    }
}