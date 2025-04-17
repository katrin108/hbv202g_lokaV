# Software Construction Project
This is an updated version of the code from **HBV202G Assignment 8** to complete the tasks in **HBV202G Assignment 11/ Software Construction Project**.  
It provides a simple implementation of a school library system that allows for book borrowing, tracking, and managing user data.

## Project overview

The project implements a basic library system with features like:
- Book borrowing and returning functionality
- Management of book authors and user roles (Faculty, Student)
- Exception handling for various error cases (e.g., book or user not found)
- System for tracking borrowed books and their due dates.

This project serves as a foundation for exploring concepts like object-oriented programming, design patterns, and software construction best practices.

### Design Features
- **User Management**: Includes different user roles (`Student`, `FacultyMember`), where each has its own behavior.
- **Book Management**: Users can borrow and return books, and the system tracks each book's availability.
- **Error Handling**: Custom exceptions are used to handle cases like missing users or books in the system.


## Project Structure

The project follows the typical Maven directory layout:

### `src/main/java/is/hi/kas108/hbv202g/assignment11`:
- **`Author.java`**: Contains the `Author` class and its implementations.
- **`Book.java`**: Contains the `Book` class and its implementations.
- **`EmptyAuthorListException.java`**: Custom exception thrown when the author list is empty and extends `Exception`.
- **`FacultyMember.java`**: Contains the `FacultyMember` class, which extends the `User` class and its implementations.
- **`Lending.java`**: Contains the `Lending` class that manages the borrowing of books.
- **`LibrarySystem.java`**: Core class for managing the library, handling operations like borrowing, returning, and searching for books.
- **`Main.java`**: Entry point for the program where the system is run and thorws `EmptyAuthorListException`
- **`Student.java`**: Contains the `Student` class, which extends the `User` class and its implementations.
- **`User.java`**: Abstract class representing a user (either `Student` or `FacultyMember`).
- **`UserOrBookDoesNotExistException.java`**: Custom exception thrown when a user or book is not found in the system and extends `Exception`.


### `src/test/java/is/hi/kas108/hbv202g/assignment11`:
- **`AuthorTest.java`**: Test cases for the `Author` class.
- **`BookTest.java`**: Test cases for the `Book` class.
- **`FacultyMemberTest.java`**: Test cases for the `FacultyMember` class.
- **`LendingTest.java`**: Test cases for the `Lending` class.
- **`LibrarySystemTest.java`**: Test cases for the `LibrarySystem` class.
- **`MainTest.java`**: Test cases for the `Main` class.
- **`UserTest.java`**: Test cases for the `User` class.



## How to Install and Run

### Prerequisites:
- Java **17** or higher
- Maven **3.6** or higher

### Steps to Install and Run:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/katrin108/hbv202g_lokaV.git
    cd hbv202g_lokaV
    ```

2. **To compile the project**, run:
    ```bash
    mvn compile
    ```

3. **To run the tests**, use:
    ```bash
    mvn test
    ```

4. **To run the main application**, execute:
    ```bash
    mvn exec:java
    ```

5. **To package the application** (create a JAR file):
    ```bash
    mvn package
    ```

6. **To generate the project's site documentation**, use:
    ```bash
    mvn site
    ```

This will execute the `main` method in `main.java`, which demonstrates how the `LibrarySystem` works.

## Usage

The `main` method in `IntStackMain.java` demonstrates the usage of the `IntStack` class. You can view the results in the terminal after running the application.

## Documentation


### **Generating Documentation**  



## UML Class Diagram  
A UML class diagram representing the project structure can be found [here](src/site/resources/classes.png).  


## Credits

- **Helmut Neukirchen**: Original repository template.
- **Katrin Sigurðard.**: Updated codebase.

## License

This project is licensed under the **MIT License**. See the [LICENSE](./LICENSE) file for more details.

## Contributing

If you'd like to contribute to this project:
1. Fork the repository
2. Create a new branch for your changes
3. Make your changes and commit them
4. Push to your forked repository
5. Create a pull request





