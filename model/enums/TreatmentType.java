package model.enums;

import exception.InvalidTreatmentIDException;
import util.LoggerUtil;

import java.util.logging.Logger;

/**
 * Enum representing different types of treatments available in the system.
 * Each treatment has a unique ID, name, and associated price.
 */
public enum TreatmentType {

    // Enum constants representing different treatment types with their corresponding IDs, names, and prices
    ACNE_TREATMENT(1, "Acne Treatment", 2750.0),
    SKIN_WHITENING(2, "Skin Whitening", 7650.0),
    MOLE_REMOVAL(3, "Mole Removal", 3850.0),
    LASER_TREATMENT(4, "Laser Treatment", 125000.0);

    // Logger instance to log information and errors
    private static final Logger logger = LoggerUtil.getInstance().getLogger();

    // Instance variables for treatment details
    private final int treatmentID;
    private final String name;
    private final double price;

    /**
     * Constructor to initialize the treatment type with its details.
     *
     * @param treatmentID The unique ID for the treatment
     * @param name        The name of the treatment
     * @param price       The price of the treatment
     */
    TreatmentType(int treatmentID, String name, double price) {
        this.treatmentID = treatmentID;
        this.name = name;
        this.price = price;
    }

    /**
     * Retrieves the treatment type by its unique treatment ID.
     *
     * @param treatmentID The unique treatment ID
     * @return TreatmentType object corresponding to the treatmentID
     * @throws InvalidTreatmentIDException if no treatment is found with the provided treatment ID
     */
    public static TreatmentType getByTreatmentID(int treatmentID) throws InvalidTreatmentIDException {
        for (TreatmentType treatment : TreatmentType.values()) {
            if (treatment.getTreatmentID() == treatmentID) {
                return treatment;
            }
        }

        // Log the error with the invalid treatment ID
        String errorMessage = "Invalid treatment ID: " + treatmentID;
        logger.severe(errorMessage); // Using 'severe' to indicate a critical issue

        // Throw a custom exception if no matching treatment is found
        throw new InvalidTreatmentIDException("Treatment with ID " + treatmentID + " not found.");
    }

    // Getters for the treatment properties

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getTreatmentID() {
        return treatmentID;
    }

    /**
     * Custom string representation of the treatment.
     * This method provides a more readable format for displaying treatment details.
     */
    @Override
    public String toString() {
        return "TreatmentType{" +
                "treatmentID=" + treatmentID +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
