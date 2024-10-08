package lab1.q1;

import java.util.Objects;

/**
 * The Person class represents a person with a first name, last name, gender, and SIN.
 * It provides methods to get and set these properties, as well as methods to compare
 * persons and generate a string representation.
 */
public class Person {
    private String firstName; // The first name of the person
    private String lastName;  // The last name of the person
    private Gender gender;    // The gender of the person
    private int sin;          // The SIN (Social Insurance Number) of the person
    private static int COUNT = 0; // Class variable to track Person objects created

    // Enum for Gender
    public enum Gender {
        M, F, OTHER
    }

    /**
     * Constructs a new Person with the specified first name, last name, gender, and SIN.
     *
     * @param firstName The first name of the person
     * @param lastName The last name of the person
     * @param gender The gender of the person
     * @param sin The SIN of the person
     */
    public Person(String firstName, String lastName, Gender gender, int sin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.sin = sin;
        COUNT++;  // Increment count when a person is created
    }

    /**
     * Returns a string representation of the person.
     *
     * @return A string representation of the person
     */
    @Override
    public String toString() {
        return "{ " + firstName + " " + lastName + ", SIN=" + sin + ", Gender=" + gender + " }";
    }

    /**
     * Compares this person to the specified object.
     *
     * @param obj The object to compare this person against
     * @return true if the given object represents a Person equivalent to this person, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;
        return sin == person.sin &&
                firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                gender == person.gender;
    }

    /**
     * Returns a hash code value for the person.
     *
     * @return A hash code value for this person
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, sin);
    }

    /**
     * Returns the first name of the person.
     *
     * @return The first name of the person
     */
    public String getFirstName() { return firstName; }

    /**
     * Sets the first name of the person.
     *
     * @param firstName The new first name of the person
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Returns the last name of the person.
     *
     * @return The last name of the person
     */
    public String getLastName() { return lastName; }

    /**
     * Sets the last name of the person.
     *
     * @param lastName The new last name of the person
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Returns the gender of the person.
     *
     * @return The gender of the person
     */
    public Gender getGender() { return gender; }

    /**
     * Sets the gender of the person.
     *
     * @param gender The new gender of the person
     */
    public void setGender(Gender gender) { this.gender = gender; }

    /**
     * Returns the SIN of the person.
     *
     * @return The SIN of the person
     */
    public int getSin() { return sin; }

    /**
     * Sets the SIN of the person.
     *
     * @param sin The new SIN of the person
     */
    public void setSin(int sin) { this.sin = sin; }

    /**
     * Manual cleanup method to decrement COUNT.
     */
    public void cleanup() {
        COUNT--;  // Decrement count when cleanup is called
    }

    /**
     * Returns the count of Person objects created.
     *
     * @return The count of Person objects created
     */
    public static int getCount() {
        return COUNT;
    }
}