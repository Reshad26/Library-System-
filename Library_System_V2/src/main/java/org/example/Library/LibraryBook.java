// LibraryBook.java
package org.example.Library;

/**
 * The LibraryBook class represents a book in the library system.
 * It holds the details of a book including title, author, and price.
 */
public class LibraryBook {

    // Instance variables for the title, author, and price of the book
    private String title;
    private String author;
    private double price;

    /**
     * Constructor initializes the book with its title, author, and price.
     *
     * @param title The title of the book
     * @param author The author of the book
     * @param price The price of the book
     */
    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    /**
     * Getter for the book's title.
     *
     * @return The title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the book's author.
     *
     * @return The author of the book
     */
    public String getAuthor() {
        return author;  // Return the author's name
    }

    /**
     * Getter for the book's price.
     *
     * @return The price of the book
     */
    public double getPrice() {
        return price;  // Return the book's price
    }

    /**
     * Provides a string representation of the book object.
     *
     * @return A string representing the book's details
     */
    @Override
    public String toString() {
        return "LibraryBook{" +
                "title='" + title + '\'' +  // Display title
                ", author='" + author + '\'' +  // Display author
                ", price=" + price +  // Display price
                '}';
    }
}