package model;

import java.util.Objects;

public class Person {
    private int NIC;
    private String name;
    private String email;
    private int phoneNumber;

    /**
     * Constructs a Person object with the provided details.
     * @param NIC The National Identity Card number of the person.
     * @param name The name of the person.
     * @param email The email address of the person.
     * @param phoneNumber The phone number of the person.
     * @throws IllegalArgumentException if any of the parameters are invalid.
     */
    public Person(int NIC, String name, String email, int phoneNumber) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        if (phoneNumber <= 0) {
            throw new IllegalArgumentException("Phone number must be a positive integer.");
        }
        this.NIC = NIC;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public int getNIC() {
        return NIC;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        if (phoneNumber <= 0) {
            throw new IllegalArgumentException("Phone number must be a positive integer.");
        }
        this.phoneNumber = phoneNumber;
    }

    /**
     * Provides a string representation of the person object.
     * @return A string describing the person's details.
     */
    @Override
    public String toString() {
        return "Person{" +
                "NIC=" + NIC +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    /**
     * Compares this person object with another for equality.
     * @param obj The object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return NIC == person.NIC &&
                phoneNumber == person.phoneNumber &&
                name.equals(person.name) &&
                email.equals(person.email);
    }

    /**
     * Generates a hash code for the person object based on its fields.
     * @return A hash code for the person.
     */
    @Override
    public int hashCode() {
        return Objects.hash(NIC, name, email, phoneNumber);
    }
}
