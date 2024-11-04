package Library;

import java.util.*;


/**
 * Represents a book with information about its author, title, year of publication and price.
 */
public class Book {
    String author;
    String title;
    int year;
    double price;


    /**
     * Creates a new book object with the specified parameters.
     *
     * @param author The author of the book.
     * @param price  The price of the book.
     * @param title  Title of the book.
     * @param year   The year the book was published.
     */
    public Book(String author, int price, String title, int year) {
        this.author = author;
        this.price = price;
        this.title = title;
        this.year = year;
    }


    // Getters and setters for the book's attributes'
    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    // Method to compare two books based on their titles
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && price == book.price && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }


    @Override
    public int hashCode() {
        return Objects.hash(author, title, year, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}


