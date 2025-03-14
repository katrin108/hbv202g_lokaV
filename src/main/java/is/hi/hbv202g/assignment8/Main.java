package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) {

        //create library
        LibrarySystem myLibrarySystem = new LibrarySystem();

        //create new books in the system

        myLibrarySystem.addBookWithTitleAndNameOfSingleAuthor("Narnia", "C. S. Lewis");
        myLibrarySystem.addBookWithTitleAndNameOfSingleAuthor("hitchiker's guide to the galaxy", "Douglas Adams");
        myLibrarySystem.addBookWithTitleAndAuthorList("Good omens", List.of(new Author("Terry Pratchett"), new Author("Neil Gaiman")));

        //create new users in the system

        myLibrarySystem.addStudentUser("Ari", true);
        myLibrarySystem.addStudentUser("Anna", true);


        //find books and users in the system

        Book narnia = myLibrarySystem.findBookByTitle("Narnia");
        User ari = myLibrarySystem.findUserByName("Ari");


        //borrow a book

        myLibrarySystem.borrowBook(ari, narnia);

        //extend a lending

        myLibrarySystem.extendLending(new FacultyMember("Andri", "Computer Science"), narnia, LocalDate.now().plusDays(7));

        //return a book

        myLibrarySystem.returnBook(ari, narnia);



    }
}
