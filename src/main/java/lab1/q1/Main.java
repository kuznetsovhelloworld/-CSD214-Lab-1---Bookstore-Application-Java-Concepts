package lab1.q1;

public class Main {
    public static void main(String[] args) {
        // Creating Person objects
        Person p1 = new Person("Rodrigo", "Sanchez", Person.Gender.M, 1234);
        Person p2 = new Person("Rodney", "Martin", Person.Gender.M, 5678);

        // Print the details of the person
        System.out.println(p1);
        System.out.println(p2);
    }
}
