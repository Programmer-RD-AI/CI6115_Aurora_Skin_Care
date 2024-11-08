package model;

import model.enums.Dermatologist;
import model.interfaces.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class DermatologistModel {
    private static final Logger logger = Logger.getLogger(DermatologistModel.class.getName());
    private final Dermatologist dermatologist;  // Static data from the enum
    private final List<Time> availableTimeSlots; // Dynamic data for availability

    public DermatologistModel(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
        this.availableTimeSlots = new ArrayList<>(); // Initialize empty time slots
        logger.info("Created DermatologistModel for " + dermatologist.getName());
    }

    // Getters for the static data (from the enum)
    public int getNIC() {
        return dermatologist.getNIC();
    }

    public String getName() {
        return dermatologist.getName();
    }

    public String getEmail() {
        return dermatologist.getEmail();
    }

    public int getPhoneNumber() {
        return dermatologist.getPhoneNumber();
    }

    /**
     * Add a time slot to the dermatologist's availability if it doesn't overlap with existing ones.
     * @param time The time slot to add
     * @return true if the time slot was added, false if it overlaps with an existing slot
     */
    public boolean addTimeSlot(Time time) {
        if (checkAvailability(time)) {
            availableTimeSlots.add(time);
            logger.info("Added new time slot: " + time + " for " + dermatologist.getName());
            return true;
        } else {
            logger.warning("Failed to add time slot: " + time + " for " + dermatologist.getName() + ". It overlaps with an existing slot.");
            return false;
        }
    }

    /**
     * Check if a specific time slot is available (does not overlap with existing ones).
     * @param time The time slot to check
     * @return true if the time slot is available, false if it overlaps with an existing one
     */
    public boolean checkAvailability(Time time) {
        for (Time bookedTime : availableTimeSlots) {
            // Check for overlap between booked time and the new time
            if (time.getDate().equals(bookedTime.getDate()) &&
                    time.getStartTime().isBefore(bookedTime.getEndTime()) &&
                    bookedTime.getStartTime().isBefore(time.getEndTime())) {
                return false; // Time slot overlaps with an existing one
            }
        }
        return true;
    }

    /**
     * Get a copy of available time slots to ensure immutability of the internal list.
     * @return An immutable list of available time slots
     */
    public List<Time> getAvailableTimeSlots() {
        return Collections.unmodifiableList(availableTimeSlots); // Return an unmodifiable list to ensure encapsulation
    }

    @Override
    public String toString() {
        return String.format("DermatologistModel{dermatologist=%s, availableTimeSlots=%s}",
                dermatologist.getName(), availableTimeSlots);
    }
}
