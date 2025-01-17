// DatabaseConnection.java
package org.example.Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DatabaseConnection class provides a method to establish a connection
 * to the PostgreSQL database. This class is responsible for handling the database
 * connection parameters and creating a connection object that can be used by
 * other classes for database operations.
 */
public class DatabaseConnection {

    // Database connection details: URL, username, and password
    private static final String URL = "jdbc:postgresql://localhost:5432/library_db";  // URL of the PostgreSQL database
    private static final String USER = "your_username";  // Replace with actual database username
    private static final String PASSWORD = "your_password";  // Replace with actual database password

    /**
     * Establishes and returns a connection to the PostgreSQL database.
     *
     * @return A Connection object that is used to interact with the database
     * @throws SQLException If an error occurs while trying to connect to the database
     */
    public static Connection getConnection() throws SQLException {
        // Attempt to establish and return a connection to the database
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}