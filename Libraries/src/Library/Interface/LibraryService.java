package Library.Interface;

import Library.Book;

import java.util.List;

public interface LibraryService {
    void addBook(Book book);
    void deleteBook(Book book);
    Book findBookByTitle(String title);
    List<Book> searchBooksByAuthor(String author);
    List<Book> searchBooksByYear(int year);
    List<Book> searchBooksByTitle(String title);
    void sortByTitle();
    void sortByAuthor();
    void sortByYear();
    void sortByPrice();
}
