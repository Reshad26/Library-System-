Library Management System
This Java-based Library Management System allows users to manage a library through functionalities like adding, borrowing, returning, and searching for books. Designed for ease of use, it employs a console-based interface with modular, threaded operations for efficient book management.

Features
Book Management: Add, remove, search, and sort books by title, author, year, and price.
User Management: Users can borrow and return books, with borrowed books tracked for each user.
Multithreading: Uses threading for efficient book addition and deletion.
Search Functions: Search books by title, author, or year of publication.
Project Structure
Main: Entry point for the application with a console menu.
LibraryManager: Core library operations, managing book collections and multi-threaded tasks.
Users: Manages user actions such as borrowing and returning books.
Book: Represents individual books, including author, title, year, and price.
Interface (LibraryService, UserService): Interfaces defining the structure for library and user operations.
Getting Started
Prerequisites
Java (version 8 or higher)
Git (optional, for version control)

Usage
Upon running, the system will display a menu to:

Borrow a book
Return a book
Search for a book
Add a new book
Exit
Example: To borrow a book, choose option 1, then enter the book's title. The system confirms if the book is available.

Contributing
Feel free to fork the repository and submit pull requests. Ensure code style consistency and include comments.