// LibraryManager.java
package org.example.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LibraryManager class manages the collection of books in the library.
 * It provides methods to add, find, and display books in the library.
 */
public class LibraryManager {

    // List to store all the books in the library
    private List<LibraryBook> books;

    /**
     * Constructor initializes the books list.
     */
    public LibraryManager() {
        books = new ArrayList<>();
    }

    /**
     * Adds a new book to the library collection.
     *
     * @param book The book to be added to the library
     */
    public void addBook(LibraryBook book) {
        books.add(book);  // Add book to the list
        System.out.println("Added book: " + book.getTitle());  // Output message confirming addition
    }

    /**
     * Finds books in the library by their title (case insensitive).
     *
     * @param title The title of the book to search for
     * @return A list of books that match the title
     */
    public List<LibraryBook> findBooksByTitle(String title) {
        return books.stream()  // Stream through the books collection
                .filter(book -> book.getTitle().equalsIgnoreCase(title))  // Filter by title (case insensitive)
                .collect(Collectors.toList());  // Collect matching books into a list
    }

    /**
     * Displays all the books in the library.
     * If no books are available, it prints a message indicating the library is empty.
     */
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");  // Message if no books are available
        } else {
            books.forEach(System.out::println);  // Print each book in the library
        }
    }

    /**
     * Retrieves a book by its title (case insensitive).
     *
     * @param title The title of the book to retrieve
     * @return The book if found, or null if no book matches the title
     */
    public LibraryBook getBookByTitle(String title) {
        return books.stream()  // Stream through the books collection
                .filter(book -> book.getTitle().equalsIgnoreCase(title))  // Filter by title (case insensitive)
                .findFirst()  // Find the first matching book
                .orElse(null);  // Return null if no book is found
    }
}