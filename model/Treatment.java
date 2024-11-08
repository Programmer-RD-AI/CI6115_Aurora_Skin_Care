package model;

import exception.InvalidTreatmentIDException;
import model.enums.TreatmentType;

import java.util.HashMap;
import java.util.Map;

public class Treatment {
    private String name;
    private double price;
    private int treatmentID;

    // Use a Map to cache instances of treatments
    private static final Map<Integer, Treatment> treatmentCache = new HashMap<>();

    /**
     * Constructor to initialize a Treatment object with the given treatmentID.
     *
     * @param treatmentID The ID for the treatment.
     * @throws InvalidTreatmentIDException If the treatmentID is invalid.
     */
    public Treatment(int treatmentID) throws InvalidTreatmentIDException {
        this.treatmentID = treatmentID;
        // Retrieve the TreatmentType associated with the treatmentID
        TreatmentType treatmentType = TreatmentType.getByTreatmentID(treatmentID);
        if (treatmentType == null) {
            throw new InvalidTreatmentIDException("Invalid treatment ID: " + treatmentID);
        }
        this.name = treatmentType.getName();
        this.price = treatmentType.getPrice();
    }

    /**
     * Gets the name of the treatment.
     *
     * @return The name of the treatment.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the treatment.
     *
     * @return The price of the treatment.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the treatmentID of the treatment.
     *
     * @return The treatmentID.
     */
    public int getTreatmentID() {
        return treatmentID;
    }

    /**
     * Gets an instance of the Treatment object for the specified treatmentID.
     * This method ensures that only one instance of each treatmentID exists.
     *
     * @param treatmentID The treatment ID for the treatment to be retrieved.
     * @return The Treatment object associated with the given treatmentID.
     * @throws InvalidTreatmentIDException If the treatmentID is invalid.
     */
    public static Treatment getInstance(int treatmentID) throws InvalidTreatmentIDException {
        // Check if the treatment instance already exists in the cache
        Treatment treatment = treatmentCache.get(treatmentID);
        if (treatment == null) {
            // If it doesn't exist, create a new instance and cache it
            treatment = new Treatment(treatmentID);
            treatmentCache.put(treatmentID, treatment);
        }
        return treatment;
    }

    /**
     * Provides a string representation of the Treatment object.
     *
     * @return A string representing the Treatment.
     */
    @Override
    public String toString() {
        return "Treatment{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", treatmentID=" + treatmentID +
                '}';
    }
}
