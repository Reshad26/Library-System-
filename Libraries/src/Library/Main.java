package Library;
//1.Описание: Создай консольное приложение для управления библиотекой.

//2.Пользователи могут брать книги, возвращать их, а библиотекари — добавлять и удалять книги, отслеживать доступные копии и т.д.

//3.Java Core: В этом проекте задействуешь коллекции для хранения данных о книгах и пользователях,
// многопоточность для обработки нескольких запросов, а также сериализацию, чтобы сохранять данные.

//4.Расширение: Добавь возможность работать с файлами JSON или XML для хранения данных о книгах и клиентах.


import java.util.Scanner;

/**
 * The Main class serves as the entry point for the Library application.
 * It initializes the library manager, sets up sample data, and provides
 * a console-based user interface for interacting with the library system.
 * Users can borrow books, return books, search for books, and add new books
 * to the library.
 */
public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);


        // Initialize test data
        libraryManager.addBook(new Book("Author1", 100, "Book1", 2020));
        libraryManager.addBook(new Book("Author2", 200, "Book2", 2019));
        libraryManager.addBook(new Book("Author3", 300, "Book3", 2018));

        System.out.println("\n" + "Welcome to the library!");

        // Main menu loop
        boolean running = true;
        while (running) {
            System.out.println("Select action:");
            System.out.println("1.Take a book");
            System.out.println("2.Return the book");
            System.out.println("3.Book search");
            System.out.println("4.Add book");
            System.out.println("5.Exit");

            String input = scanner.nextLine().trim(); // Read the input and trim whitespace

            if (input.isEmpty()) {
                System.out.println("Error: Please enter an action number.");
                continue; // Return to the start of the loop
            }

            try {
                int choice = Integer.parseInt(input); // Convert the input to an integer

                // Validate the choice
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid action number. Please select a number from 1 to 5.");
                    continue; // Return to the start of the loop
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter the title of the book you want to borrow: ");
                        String bookToTake = scanner.nextLine();
                        Book bookFound = libraryManager.findBookByTitle(bookToTake);
                        if (bookFound != null) {
                            System.out.println("You took the book: " + bookFound.getTitle());
                        } else {
                            System.out.println("Book not found");
                        }
                        break;

                    case 2:
                        System.out.print("Enter the title of the book you want to return: ");
                        String bookToReturn = scanner.nextLine();
                        // Logic for returning the book can be added here
                        System.out.println("Thank you for returning the book: " + bookToReturn);
                        break;

                    case 3:
                        System.out.print("Enter the title of the book to search: ");
                        String bookToFind = scanner.nextLine();
                        Book foundBook = libraryManager.findBookByTitle(bookToFind);
                        if (foundBook != null) {
                            System.out.println("Book found!");
                            System.out.println("Title: " + foundBook.getTitle());
                            System.out.println("Аuthor: " + foundBook.getAuthor());
                            System.out.println("Year:" + foundBook.getYear());
                            System.out.println("Price: " + foundBook.getPrice());
                        } else {
                            System.out.println("Book not found");
                        }
                        break;

                    case 4:
                        System.out.print("Enter the title of the new book:");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter the author of the book: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("Enter the price of the book: ");
                        int newPrice = scanner.nextInt();
                        System.out.print("Enter the price of the book: ");
                        int newYear = scanner.nextInt();
                        scanner.nextLine(); // Clear the scanner

                        Book newBook = new Book(newAuthor, newPrice, newTitle, newYear);
                        libraryManager.addBook(newBook);
                        System.out.println("A new book has been added.");
                        break;

                    case 5:
                        System.out.println("Exit the program. Thanks for using!");
                        running = false;
                        break;

                    default:
                        System.out.println("Envelope then Basic Latin");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter an integer.");
            }
        }

        scanner.close(); // Close the scanner resource
    }
}







