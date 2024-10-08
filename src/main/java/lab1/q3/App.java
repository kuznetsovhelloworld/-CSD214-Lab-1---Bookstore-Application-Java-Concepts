package lab1.q3;

import lab1.q2.Book;
import lab1.q1.Person;

import java.util.Scanner;

/**
 * The App class provides a console-based application to manage books.
 * It allows adding, editing, deleting, listing, and selling books.
 */
public class App {
    private final int numBooks = 100; // Array size for books
    private Book[] unsoldBooks = new Book[numBooks]; // Array to store unsold books
    private Book[] soldBooks = new Book[numBooks];   // Array to store sold books
    private int unsoldCurrentIndex = 0; // Tracks the current index of unsold books
    private int soldCurrentIndex = 0;   // Tracks the current index of sold books
    private Scanner input = new Scanner(System.in); // For user input

    // Menu options
    private String menu = """
        ----------------
        1. Add a Book
        2. Edit a Book
        3. Delete an Unsold Book
        4. Delete a Sold Book
        5. List Unsold Books
        6. List Sold Books
        7. Sell a Book
        99. Exit
        ----------------
        """;

    /**
     * Runs the application, displaying the menu and handling user input.
     */
    public void run() {
        int choice;
        do {
            System.out.println(menu);
            choice = input.nextInt();
            input.nextLine(); // Clear the input buffer
            switch (choice) {
                case 1 -> addBook();
                case 2 -> editBook();
                case 3 -> deleteUnsoldBook();
                case 4 -> deleteSoldBook();
                case 5 -> listUnsoldBooks();
                case 6 -> listSoldBooks();
                case 7 -> sellBook();
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 99);
    }

    /**
     * Adds a new book to the unsoldBooks array.
     * Prompts the user for book details.
     */
    private void addBook() {
        if (unsoldCurrentIndex >= numBooks) {
            System.out.println("No more space to add new books.");
            return;
        }

        System.out.print("Enter book title: ");
        String title = input.nextLine();

        System.out.print("Enter author's first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter author's last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter author's gender (M/F/OTHER): ");
        String genderInput = input.nextLine();
        Person.Gender gender = Person.Gender.valueOf(genderInput.toUpperCase());

        System.out.print("Enter author's SIN: ");
        int sin = input.nextInt();
        input.nextLine();

        System.out.print("Enter book ISBN: ");
        String isbn = input.nextLine();

        Person author = new Person(firstName, lastName, gender, sin);
        Book newBook = new Book(title, author, isbn);

        // Add the book to unsoldBooks array
        unsoldBooks[unsoldCurrentIndex++] = newBook;
        System.out.println("Book added successfully.");
    }

    /**
     * Edits an existing book in the unsoldBooks array.
     * Prompts the user for new book details.
     */
    private void editBook() {
        listUnsoldBooks();
        System.out.print("Enter the number of the book you want to edit: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index >= 0 && index < unsoldCurrentIndex) {
            Book bookToEdit = unsoldBooks[index];

            System.out.println("Editing book: " + bookToEdit);

            System.out.print("Enter new title (or press Enter to keep '" + bookToEdit.getTitle() + "'): ");
            String newTitle = input.nextLine();
            if (!newTitle.isEmpty()) bookToEdit.setTitle(newTitle);

            System.out.print("Enter new ISBN (or press Enter to keep '" + bookToEdit.getIsbn() + "'): ");
            String newIsbn = input.nextLine();
            if (!newIsbn.isEmpty()) bookToEdit.setIsbn(newIsbn);

            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Invalid book selection.");
        }
    }

    /**
     * Deletes an existing book from the unsoldBooks array.
     * Prompts the user to select a book to delete.
     */
    private void deleteUnsoldBook() {
        listUnsoldBooks();
        System.out.print("Enter the number of the book you want to delete: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index >= 0 && index < unsoldCurrentIndex) {
            for (int i = index; i < unsoldCurrentIndex - 1; i++) {
                unsoldBooks[i] = unsoldBooks[i + 1];
            }
            unsoldBooks[--unsoldCurrentIndex] = null; // Nullify the last element
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Invalid book selection.");
        }
    }

    /**
     * Deletes an existing book from the soldBooks array.
     * Prompts the user to select a sold book to delete.
     */
    private void deleteSoldBook() {
        listSoldBooks();
        System.out.print("Enter the number of the sold book you want to delete: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index >= 0 && index < soldCurrentIndex) {
            for (int i = index; i < soldCurrentIndex - 1; i++) {
                soldBooks[i] = soldBooks[i + 1];
            }
            soldBooks[--soldCurrentIndex] = null; // Nullify the last element
            System.out.println("Sold book deleted successfully.");
        } else {
            System.out.println("Invalid book selection.");
        }
    }

    /**
     * Lists all unsold books.
     */
    private void listUnsoldBooks() {
        System.out.println("Unsold Books:");
        for (int i = 0; i < unsoldCurrentIndex; i++) {
            System.out.println((i + 1) + ". " + unsoldBooks[i]);
        }
    }

    /**
     * Lists all sold books.
     */
    private void listSoldBooks() {
        System.out.println("Sold Books:");
        for (int i = 0; i < soldCurrentIndex; i++) {
            System.out.println((i + 1) + ". " + soldBooks[i]);
        }
    }

    /**
     * Sells an existing book from the unsoldBooks array.
     * Prompts the user for buyer details.
     */
    private void sellBook() {
        listUnsoldBooks();
        System.out.print("Enter the number of the book to sell: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index >= 0 && index < unsoldCurrentIndex) {
            Book soldBook = unsoldBooks[index];

            System.out.print("Enter buyer's first name: ");
            String firstName = input.nextLine();

            System.out.print("Enter buyer's last name: ");
            String lastName = input.nextLine();

            System.out.print("Enter buyer's gender (M/F/OTHER): ");
            String genderInput = input.nextLine();
            Person.Gender gender = Person.Gender.valueOf(genderInput.toUpperCase());

            System.out.print("Enter buyer's SIN: ");
            int sin = input.nextInt();
            input.nextLine();

            Person buyer = new Person(firstName, lastName, gender, sin);
            soldBook.setAuthor(buyer);

            soldBooks[soldCurrentIndex++] = soldBook;

            for (int i = index; i < unsoldCurrentIndex - 1; i++) {
                unsoldBooks[i] = unsoldBooks[i + 1];
            }
            unsoldBooks[--unsoldCurrentIndex] = null;

            System.out.println("Book sold successfully.");
        } else {
            System.out.println("Invalid book selection.");
        }
    }
}