package lab1.q2;

import lab1.q1.Person;

public class Main {
    public static void main(String[] args) {
        Person author = new Person("Rodrigo", "Sanchez", Person.Gender.M, 1234);


        Book book1 = new Book("Effective Java", author);
        Book book2 = new Book("Effective Java", author, "978-0134685991");

        // Print details of the books
        System.out.println(book1);
        System.out.println(book2);
    }
}
