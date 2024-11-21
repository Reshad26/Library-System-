package Library;

import Library.Interface.LibraryService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The LibraryManager class manages a collection of books.
 * * Allows you to add, delete, search for books and sort them according to various parameters.
 * * Also supports multi-threading for query processing.
 */


public class LibraryManager implements LibraryService {
    private List<Book> book = new ArrayList<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(10);


    /**
     * Adds a book to the library. Checks that the book title is not empty.
     * Runs the add operation in a separate thread.
     *
     * @param book the book to add to the library
     */
    @Override
    public void addBook(Book book) {

        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            System.out.println("Error: Book title cannot be empty.");
            return; //Exit the method if the name is empty
        }

        executorService.submit(() -> {
            try {
                synchronized (this.book) { //Synchronizing access to the list of books
                    this.book.add(book);
                }
                System.out.println("Book added: " + book.getTitle());
            } catch (Exception e) {
                System.out.println("Error adding a book:" + e.getMessage());
            }
        });
    }


    // Method for shutting down a thread pool
    public void shutdown() {
        executorService.shutdown(); //Shutting down the thread pool
    }


    /**
     * Deletes a book
     *
     * @param book the book to Delete to the library
     */
    @Override
    public void deleteBook(Book book) {
        // Add a task to the thread pool
        executorService.submit(() -> {
            // Synchronizing access to the list of books
            synchronized (this.book) {
                if (this.book.remove(book)) {
                    System.out.println("Book deleted: " + book.getTitle());
                } else {
                    System.out.println("Book not found: " + book.getTitle());
                }
            }
        });
    }


    /**
     * Searches for a book by title in the library and displays information about the found book.
     * If the name is empty, displays an error message.
     * If a book with the specified title is found, displays its title, author, year of publication and price.
     * If the book is not found, displays a corresponding message.
     *
     * @param title title of the book to search for
     * @return the found book or {@code null} if the book was not found or if the title is empty
     */
    @Override
    public Book findBookByTitle(String title) {
        return book.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null); //If book not found, return null
    }

    /**
     * Sorts the list of books by year of publication in ascending order.
     */
    @Override
    public void sortByYear() {
        book = book.stream()
                .sorted(Comparator.comparingInt(Book::getYear))
                .toList();
    }

    /**
     * Sorts the list of books by title in alphabetical order.
     */
    @Override
    public void sortByTitle() {
        book = book.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();
    }

    /**
     * Sorts the list of books by author in alphabetical order.
     */
    @Override
    public void sortByAuthor() {
        book = book.stream()
                .sorted(Comparator.comparing(Book::getAuthor))
                .toList();
    }

    /**
     * Sorts the list of books by price in ascending order.
     */
    @Override
    public void sortByPrice() {
        book = book.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .toList();
    }


    /**
     * Removes all books with the specified title from the library.
     *
     * @param title title of the books to remove
     * @return true if any book was removed, false otherwise
     */
    public boolean removeDuplicateByTitle(String title) {
        List<Book> duplicates = book.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .skip(1) // We skip the first instance
                .toList();
        book.removeAll(duplicates);
        return !duplicates.isEmpty();
    }

    /**
     * Displays all books in the library.
     */


    /**
     * Searches for books by title, year, or author.
     * If the search term is empty, displays an error message.
     * If a book with the specified title, year, or author is found, displays its title, author, year of publication and price.
     */
    @Override
    public List<Book> searchBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : book) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /**
     * Searches for books in the library by the specified year of publication.
     *
     * @param year The publication year of the book being searched for.
     * @return A list of books published in the specified year.
     * If no books are found, an empty list is returned.
     */
    @Override
    public List<Book> searchBooksByYear(int year) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : book) {
            if (book.getYear() == year) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }


    /**
     * Searches for books in the library by the specified author.
     *
     * @param author The name of the author to search for.
     * @return A list of books written by the specified author.
     * If no books are found, an empty list is returned.
     */
    @Override
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : book) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }


}

