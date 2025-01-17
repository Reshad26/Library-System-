// UserManager.java
package org.example.Library;

import java.util.ArrayList;
import java.util.List;

/**
 * The UserManager class manages user operations such as adding users,
 * displaying users, and handling book borrow and return actions.
 * This class allows interaction between the library system and users.
 */
public class UserManager {

    // List to store all the users
    private List<User> users;

    /**
     * Constructs a new UserManager with an empty list of users.
     */
    public UserManager() {
        users = new ArrayList<>();
    }

    /**
     * Adds a new user to the list of users.
     *
     * @param user The User object to be added
     */
    public void addUser(User user) {
        users.add(user);  // Add the user to the list
        System.out.println("Added user: " + user.getName());  // Log the addition of the user
    }

    /**
     * Displays all the users in the system.
     * If no users exist, it notifies the user.
     */
    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");  // Notify if the list is empty
        } else {
            users.forEach(System.out::println);  // Display each user in the list
        }
    }

    /**
     * Retrieves a user by their name.
     *
     * @param name The name of the user to be found
     * @return The User object if found, or null if no user is found with the given name
     */
    public User getUserByName(String name) {
        // Search the list for the user by name (case insensitive)
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);  // Return null if no user is found
    }

    /**
     * Allows a user to borrow a book from the library.
     *
     * @param userName The name of the user borrowing the book
     * @param bookTitle The title of the book to be borrowed
     * @param libraryManager The library manager instance used to access the library's books
     */
    public void borrowBook(String userName, String bookTitle, LibraryManager libraryManager) {
        User user = getUserByName(userName);  // Retrieve the user by name
        LibraryBook book = libraryManager.getBookByTitle(bookTitle);  // Retrieve the book by title

        if (user == null) {
            System.out.println("User not found.");  // Error message if user is not found
        } else if (book == null) {
            System.out.println("Book not found.");  // Error message if book is not found
        } else {
            user.borrowBook(book);  // Borrow the book if both user and book exist
        }
    }

    /**
     * Allows a user to return a borrowed book to the library.
     *
     * @param userName The name of the user returning the book
     * @param bookTitle The title of the book to be returned
     * @param libraryManager The library manager instance used to access the library's books
     */
    public void returnBook(String userName, String bookTitle, LibraryManager libraryManager) {
        User user = getUserByName(userName);  // Retrieve the user by name
        LibraryBook book = libraryManager.getBookByTitle(bookTitle);  // Retrieve the book by title

        if (user == null) {
            System.out.println("User not found.");  // Error message if user is not found
        } else if (book == null) {
            System.out.println("Book not found.");  // Error message if book is not found
        } else {
            user.returnBook(book);  // Return the book if both user and book exist
        }
    }
}