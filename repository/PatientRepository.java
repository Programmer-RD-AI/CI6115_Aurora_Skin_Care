package repository;

import model.Patient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PatientRepository {
    private List<Patient> patientList;

    // Constructor to initialize with an existing list
    public PatientRepository(List<Patient> initialPatientList) {
        this.patientList = new ArrayList<>(initialPatientList);  // Create a new ArrayList to avoid external modifications
    }

    // Default constructor initializes an empty list
    public PatientRepository() {
        this.patientList = new ArrayList<>();
    }

    // Add a patient if they are not already in the list
    public boolean addPatient(Patient patient) {
        if (patient == null) {
            return false;  // Do not add null patients
        }
        if (!patientList.contains(patient)) {
            patientList.add(patient);
            return true;
        }
        return false;  // Patient already exists
    }

    // Check if a patient exists in the list
    public boolean existPatient(Patient patient) {
        return patient != null && patientList.contains(patient);
    }

    // Get a patient by index (ensure index is valid)
    public Patient getPatient(int patientIdx) {
        if (patientIdx >= 0 && patientIdx < patientList.size()) {
            return patientList.get(patientIdx);
        }
        return null;  // Return null if index is invalid
    }

    // Delete a patient by object reference
    public void deletePatient(Patient patient) {
        if (existPatient(patient)) {
            patientList.remove(patient);
        }
    }

    // Optionally, get a list of all patients (unmodifiable)
    public List<Patient> getPatientList() {
        return Collections.unmodifiableList(patientList);  // Make list unmodifiable to avoid external modifications
    }

    // Optionally, get patient count
    public int getPatientCount() {
        return patientList.size();
    }
}
