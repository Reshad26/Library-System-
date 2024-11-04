package Library;

import Library.Interface.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user in the library system, holding information about borrowed books.
 */
public class Users implements UserService {
    private List<Users> users = new ArrayList<Users>();
    private String name;
    private List<Book> borrowedBooks;

    /**
     * Creates a new user with the specified name.
     *
     * @param name The name of the user.
     */
    public Users(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    /**
     * Allows the user to borrow a book.
     *
     * @param book The book to be borrowed.
     */
    @Override
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " взял книгу: " + book.getTitle());
    }

    /**
     * Allows the user to return a previously borrowed book.
     *
     * @param book The book to be returned.
     */
    @Override
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            System.out.println(name + "returned the book: " + book.getTitle());
        } else {
            System.out.println(name + "didn't take the book: " + book.getTitle());
        }
    }

    /**
     * Searches for borrowed books by title.
     *
     * @param title The title of the book to search for.
     * @return A list of books that match the specified title.
     */
    @Override
    public List<Book> searchBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }


    /**
     * Displays all books currently borrowed by the user.
     */
    @Override
    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " didn't take a single book.");
        } else {
            System.out.println(name + "books taken:");
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }

    public String getName() {
        return name;
    }

}
