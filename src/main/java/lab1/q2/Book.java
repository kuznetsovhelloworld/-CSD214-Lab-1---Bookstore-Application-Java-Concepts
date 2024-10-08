package lab1.q2;

import lab1.q1.Person;
import java.util.*;

/**
 * The Book class represents a book with a title, ISBN, and author.
 * It provides methods to get and set these properties, as well as
 * methods to compare books and generate a string representation.
 */
public class Book {
    private String title; // The title of the book
    private String isbn;  // The ISBN of the book
    private Person author; // The author of the book
    private static int COUNT = 0; // Static counter to keep track of the number of books

    /**
     * Constructs a new Book with the specified title and author.
     *
     * @param title The title of the book
     * @param author The author of the book
     */
    public Book(String title, Person author) {
        this.title = title;
        this.author = author;
        COUNT++;
    }

    /**
     * Constructs a new Book with the specified title, author, and ISBN.
     *
     * @param title The title of the book
     * @param author The author of the book
     * @param isbn The ISBN of the book
     */
    public Book(String title, Person author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        COUNT++;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return A string representation of the book
     */
    @Override
    public String toString() {
        return "Book{" + "Name='" + title + '\'' + ", isbn='" + isbn + '\'' + ", author=" + author + '}';
    }

    /**
     * Compares this book to the specified object.
     *
     * @param obj The object to compare this book against
     * @return true if the given object represents a Book equivalent to this book, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        return title.equals(book.title) && isbn.equals(book.isbn) && author.equals(book.author);
    }

    /**
     * Returns a hash code value for the book.
     *
     * @return A hash code value for this book
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, isbn, author);
    }

    /**
     * Returns the title of the book.
     *
     * @return The title of the book
     */
    public String getTitle() { return title; }

    /**
     * Sets the title of the book.
     *
     * @param title The new title of the book
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Returns the ISBN of the book.
     *
     * @return The ISBN of the book
     */
    public String getIsbn() { return isbn; }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn The new ISBN of the book
     */
    public void setIsbn(String isbn) { this.isbn = isbn; }

    /**
     * Returns the author of the book.
     *
     * @return The author of the book
     */
    public Person getAuthor() { return author; }

    /**
     * Sets the author of the book.
     *
     * @param author The new author of the book
     */
    public void setAuthor(Person author) { this.author = author; }
}