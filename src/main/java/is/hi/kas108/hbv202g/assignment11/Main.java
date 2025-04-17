package is.hi.kas108.hbv202g.assignment11;

import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws EmptyAuthorListException {



        LibrarySystem myLibrary = new LibrarySystem();

        myLibrary.addBookWithTitleAndNameOfSingleAuthor("Narnia", "C.S. Lewis");
        System.out.println("Narnia was added to the system");
        myLibrary.addBookWithTitleAndAuthorList("Good Omens", List.of(new Author("Terry Pratchett"), new Author("Neil Gaiman")));
        System.out.println("Good Omens was added to the system");

        myLibrary.addStudentUser("Ari", false);
        System.out.println("Ari was added to the system");

        myLibrary.addFacultyMemberUser("Andri","Computer Science");
        System.out.println("Andri was added to the system");

        try {
            Book book = myLibrary.findBookByTitle("Narnia");
            System.out.println("Found book "+book.getTitle());
        }catch (UserOrBookDoesNotExistException e){
            System.out.println(e.getMessage());
        }

        try {
            User user = myLibrary.findUserByName("Ari");
            System.out.println("Found user "+user.getName());
        }catch (UserOrBookDoesNotExistException e){
            System.out.println(e.getMessage());
        }

        try{
            myLibrary.borrowBook(myLibrary.findUserByName("Ari"), myLibrary.findBookByTitle("Narnia"));
            System.out.println("Narnia was borrowed by Ari");
        }catch (UserOrBookDoesNotExistException e){
            System.out.println(e.getMessage());
        }

        try{
            myLibrary.extendLending((FacultyMember) myLibrary.findUserByName("Andri"), myLibrary.findBookByTitle("Narnia"), LocalDate.now().plusDays(2));
            System.out.println("Narnia was extended by Andri");
        }catch (UserOrBookDoesNotExistException e){
            System.out.println(e.getMessage());
        }

        try{
            myLibrary.returnBook(myLibrary.findUserByName("Ari"), myLibrary.findBookByTitle("Narnia"));
            System.out.println("Narnia was returned by Ari");
        }catch (UserOrBookDoesNotExistException e){
            System.out.println(e.getMessage());
        }

    }
}
