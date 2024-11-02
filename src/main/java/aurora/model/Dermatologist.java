package model;

import util.Utils;
import util.availability.Availability;
import util.availability.AvailabilityDataType;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Dermatologist extends Person {
    private List<Availability> availabilityTracker;  // Tracks available times
    private List<Availability> timeAllocations;      // Tracks reserved times

    public Dermatologist(String NIC, String name, String email, int telephoneNumber) {
        super(NIC, name, email, telephoneNumber);
        this.availabilityTracker = new ArrayList<>();
        this.timeAllocations = new ArrayList<>();
        initializeDefaultAvailability();
    }

    // Initialize default availability (this would depend on your AvailabilityDataType enum)
    private void initializeDefaultAvailability() {
        for (AvailabilityDataType type : AvailabilityDataType.values()) {
            addAvailability(type.getDay(), type.getStartTime(), type.getEndTime());
        }
    }

    // Add default availability time slot
    public void addAvailability(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        Availability availability = new Availability(day, startTime, endTime);
        availabilityTracker.add(availability);
    }

    // Check if a reservation can be added based on availability and overlap
    public boolean canAddReservation(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        for (Availability availability : availabilityTracker) {
            if (availability.getDay() == day &&
                    !startTime.isBefore(availability.getStartTime()) &&
                    !endTime.isAfter(availability.getEndTime()) &&
                    isTimeAvailable(day, startTime, endTime)) {

                // Check if the duration is a multiple of 15 minutes
                if (startTime.plusMinutes(15).equals(endTime)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Add a reservation if the time slot is valid
    public void addReservation(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        if (canAddReservation(day, startTime, endTime)) {
            timeAllocations.add(new Availability(day, startTime, endTime));
            System.out.println("Reservation added for " + day + " from " + startTime + " to " + endTime);
        } else {
            System.out.println("Invalid reservation time.");
        }
    }

    // Check if a time slot is available (no overlap with existing reservations)
    public boolean isTimeAvailable(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        for (Availability reservation : timeAllocations) {
            if (reservation.getDay() == day && Utils.isOverlapping(reservation.getStartTime(), reservation.getEndTime(), startTime, endTime)) {
                return false;
            }
        }
        return true;
    }

    public List<Availability> getAvailabilityTracker() {
        return availabilityTracker;
    }

    public List<Availability> getTimeAllocations() {
        return timeAllocations;
    }
}
