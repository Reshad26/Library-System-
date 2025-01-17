// User.java
package org.example.Library;

import java.util.ArrayList;
import java.util.List;

/**
 * The User class represents a user in the library system.
 * Each user has a name and a list of borrowed books.
 * This class provides methods to borrow and return books from the library.
 */
public class User {

    // The user's name
    private String name;

    // List of books borrowed by the user
    private List<LibraryBook> borrowedBooks;

    /**
     * Constructs a new User with the specified name.
     * Initializes an empty list of borrowed books.
     *
     * @param name The name of the user
     */
    public User(String name) {
        this.name = name;  // Set the user's name
        this.borrowedBooks = new ArrayList<>();  // Initialize the borrowed books list
    }

    /**
     * Retrieves the user's name.
     *
     * @return The name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the list of books borrowed by the user.
     *
     * @return The list of borrowed books
     */
    public List<LibraryBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     * Borrows a book from the library and adds it to the user's list of borrowed books.
     *
     * @param book The LibraryBook object to be borrowed
     */
    public void borrowBook(LibraryBook book) {
        borrowedBooks.add(book);  // Add the book to the borrowed list
        System.out.println(name + " borrowed the book: " + book.getTitle());  // Log the borrowing action
    }

    /**
     * Returns a borrowed book to the library.
     * If the user hasn't borrowed the book, an error message is displayed.
     *
     * @param book The LibraryBook object to be returned
     */
    public void returnBook(LibraryBook book) {
        // Attempt to remove the book from the borrowed list
        if (borrowedBooks.remove(book)) {
            System.out.println(name + " returned the book: " + book.getTitle());  // Log the return action
        } else {
            // Display an error if the book wasn't found in the borrowed list
            System.out.println(name + " didn't borrow the book: " + book.getTitle());
        }
    }

    /**
     * Provides a string representation of the user, including their name and borrowed books.
     *
     * @return A string representing the user and their borrowed books
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';  // Return user information
    }
}