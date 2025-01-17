// Main.java
package org.example.Library;

import java.util.Scanner;

/**
 * The Main class provides the entry point for the Library Management System.
 * It facilitates interaction between the user and the system, allowing for
 * actions such as adding books, adding users, borrowing books, and returning books.
 */
public class Main {

    public static void main(String[] args) {
        // Initialize the LibraryManager to handle book-related operations
        LibraryManager libraryManager = new LibraryManager();

        // Initialize the UserManager to handle user-related operations
        UserManager userManager = new UserManager();

        // Initialize Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Infinite loop for interacting with the system until the user decides to exit
        while (true) {
            // Display the main menu with available options
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. List All Books");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Add User");
            System.out.println("5. List All Users");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Read the user's menu choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the choice

            // Handle the user's choice by executing the corresponding case
            switch (choice) {
                case 1:
                    // Case 1: Add a new book to the library
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline after reading a double value
                    // Add the new book to the library
                    libraryManager.addBook(new LibraryBook(title, author, price));
                    break;

                case 2:
                    // Case 2: List all books in the library
                    libraryManager.displayBooks();
                    break;

                case 3:
                    // Case 3: Find a book by its title and display the result
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    libraryManager.findBooksByTitle(searchTitle).forEach(System.out::println);
                    break;

                case 4:
                    // Case 4: Add a new user to the system
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    // Add the new user to the user manager
                    userManager.addUser(new User(userName));
                    break;

                case 5:
                    // Case 5: List all registered users
                    userManager.displayUsers();
                    break;

                case 6:
                    // Case 6: Borrow a book for a user
                    System.out.print("Enter user name: ");
                    String borrowerName = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String borrowTitle = scanner.nextLine();
                    // Borrow the book for the user
                    userManager.borrowBook(borrowerName, borrowTitle, libraryManager);
                    break;

                case 7:
                    // Case 7: Return a borrowed book
                    System.out.print("Enter user name: ");
                    String returnerName = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String returnTitle = scanner.nextLine();
                    // Return the book for the user
                    userManager.returnBook(returnerName, returnTitle, libraryManager);
                    break;

                case 0:
                    // Case 0: Exit the program gracefully
                    System.out.println("Exiting... Goodbye!");
                    scanner.close(); // Close the scanner resource
                    return; // Exit the program

                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}