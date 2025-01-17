// BookDAO.java
package org.example.Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The BookDAO (Data Access Object) class provides methods to interact with the
 * books table in the database. It contains methods for adding books to the
 * database and retrieving all books from the database.
 */
public class BookDAO {

    /**
     * Adds a new book to the database.
     *
     * @param book The LibraryBook object to be added to the database
     */
    public void addBook(LibraryBook book) {
        // SQL query for inserting a new book into the books table
        String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";

        // Try-with-resources statement to automatically close resources
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the parameters for the prepared statement
            stmt.setString(1, book.getTitle());  // Set book title
            stmt.setString(2, book.getAuthor()); // Set book author
            stmt.setDouble(3, book.getPrice());  // Set book price

            // Execute the query to insert the book into the database
            stmt.executeUpdate();
            System.out.println("Book added to the database: " + book.getTitle());

        } catch (SQLException e) {
            // Print error message if the operation fails
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    /**
     * Retrieves all books from the database.
     *
     * @return A List of LibraryBook objects containing all books in the database
     */
    public List<LibraryBook> getAllBooks() {
        // SQL query for selecting all books from the books table
        String sql = "SELECT * FROM books";
        List<LibraryBook> books = new ArrayList<>();  // List to store retrieved books

        // Try-with-resources statement to automatically close resources
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Iterate through the result set and create LibraryBook objects
            while (rs.next()) {
                LibraryBook book = new LibraryBook(
                        rs.getString("title"),   // Get title from the result set
                        rs.getString("author"),  // Get author from the result set
                        rs.getDouble("price")    // Get price from the result set
                );
                books.add(book);  // Add the created book to the list
            }
        } catch (SQLException e) {
            // Print error message if the operation fails
            System.out.println("Error retrieving books: " + e.getMessage());
        }

        // Return the list of books
        return books;
    }
}