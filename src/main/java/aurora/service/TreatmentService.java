package service;

import model.Treatment;
import java.util.ArrayList;
import java.util.List;

public class TreatmentService {
    private List<Treatment> treatmentList;

    public TreatmentService() {
        treatmentList = new ArrayList<>();
    }

    public void addTreatment(Treatment treatment) {
        treatmentList.add(treatment);
    }

    // Getter for the treatment list
    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }
}
