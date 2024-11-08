package repository;

import model.DermatologistModel;
import model.interfaces.Time;
import model.enums.Dermatologist;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DermatologistRepository {

    // Using a ConcurrentHashMap for thread-safety if this repository is accessed by multiple threads
    private final Map<Dermatologist, DermatologistModel> dermatologistSchedule = new ConcurrentHashMap<>();

    public DermatologistRepository() {
        // Initialize the schedule for each dermatologist with an empty schedule
        for (Dermatologist dermatologist : Dermatologist.values()) {
            dermatologistSchedule.put(dermatologist, new DermatologistModel(dermatologist));
        }
    }

    // Check if a time slot is available for the given dermatologist
    public boolean isTimeSlotAvailable(Dermatologist dermatologist, Time time) {
        DermatologistModel model = dermatologistSchedule.get(dermatologist);
        return model != null && model.checkAvailability(time);
    }

    // Add a time slot for the dermatologist if it's available
    public boolean addTimeSlot(DermatologistModel model, Time time) {
        // Check if the dermatologist is valid and the time slot is available before adding
        if (model != null && model.checkAvailability(time)) {
            model.addTimeSlot(time);
            return true;
        }
        return false;
    }

    // Retrieve the list of available time slots for a given dermatologist
    public List<Time> getSchedule(Dermatologist dermatologist) {
        DermatologistModel model = dermatologistSchedule.get(dermatologist);
        return (model != null) ? model.getAvailableTimeSlots() : List.of(); // Return an empty list if no model found
    }

    // Optional: Clear all schedules (useful for testing or resetting the repository)
    public void clearSchedule() {
        dermatologistSchedule.clear();
    }
}
