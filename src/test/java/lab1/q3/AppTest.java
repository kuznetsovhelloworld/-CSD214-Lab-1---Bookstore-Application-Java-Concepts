package lab1.q3;


import lab1.q1.Person;
import lab1.q2.Book;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testPersonEquals() {
        // Creating Person objects
        Person p1 = new Person("Joshua", "Bloch", Person.Gender.M, 1234);
        Person p2 = new Person("Joshua", "Bloch", Person.Gender.M, 1234);
        Person p3 = new Person("Joshua", "Bloch", Person.Gender.M, 12345);
        Person p4 = p1;

        // Testing equals
        assertTrue(p1.equals(p2));   // Should be true, same details
        assertTrue(p1.equals(p4));   // Should be true, both point to the same object
        assertFalse(p1.equals(p3));  // Should be false, different SIN
    }

    @Test
    public void testBookEquals() {
        // Creating Person object for the author
        Person author = new Person("Joshua", "Bloch", Person.Gender.M, 1234);

        // Creating Book objects
        Book b1 = new Book("Effective Java", author, "978-0134685991");
        Book b2 = new Book("Effective Java", author, "978-0134685991");
        Book b3 = new Book("Effective Java", author, "978-01346859910");
        Book b4 = b1;

        // Testing equals
        assertTrue(b1.equals(b2));   // Should be true, same title, author, and ISBN
        assertTrue(b1.equals(b4));   // Should be true, both point to the same object
        assertFalse(b1.equals(b3));  // Should be false, different ISBN
    }
}
