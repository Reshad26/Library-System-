package Library.Interface;

import Library.Book;

import java.util.List;

public interface UserService {
    void borrowBook(Book book);
    void returnBook(Book book);
    List<Book> searchBooksByTitle(String title);
    void displayBorrowedBooks();
}
