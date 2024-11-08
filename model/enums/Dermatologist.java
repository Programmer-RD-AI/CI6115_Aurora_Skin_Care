package model.enums;

import util.LoggerUtil;

import java.util.logging.Logger;

/**
 * Enum representing different dermatologists available in the system.
 * Each dermatologist has a unique set of attributes including NIC, name, email, and phone number.
 */
public enum Dermatologist {

    // Enum constants representing specific dermatologists
    DR_SMITH(123456789, "Dr. John Smith", "dr.smith@example.com", 987654321),
    DR_JONES(987654321, "Dr. Emily Jones", "dr.jones@example.com", 123456789),
    DR_BROWN(111223344, "Dr. Michael Brown", "dr.brown@example.com", 333444555);

    // Logger instance for logging errors and information
    private final java.util.logging.Logger logger = LoggerUtil.getInstance().getLogger();

    // Instance variables for each dermatologist
    private final int NIC;
    private final String name;
    private final String email;
    private final int phoneNumber;

    /**
     * Enum constructor to initialize dermatologist data.
     *
     * @param NIC           National Identity Card (NIC) number
     * @param name          Name of the dermatologist
     * @param email         Email address of the dermatologist
     * @param phoneNumber   Contact phone number of the dermatologist
     */
    Dermatologist(int NIC, String name, String email, int phoneNumber) {
        this.NIC = NIC;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters for dermatologist properties

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

    /**
     * Custom string representation of the dermatologist.
     * It omits sensitive information such as NIC and phone number.
     */
    @Override
    public String toString() {
        return "Dermatologist{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
