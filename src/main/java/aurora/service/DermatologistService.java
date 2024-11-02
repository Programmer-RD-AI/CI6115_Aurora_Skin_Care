package service;

import model.Dermatologist;
import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class DermatologistService {
    private List<Dermatologist> dermatologists = new ArrayList<>();

    public void addDermatologist(Dermatologist dermatologist){
        dermatologists.add(dermatologist);
    }

    public List<Dermatologist> getAllDermatologist(){
        return new ArrayList<>(dermatologists);
    }

    public void updateDermatologist(Dermatologist dermatologist){
        Dermatologist existingDermatologist = Utils.findInList(dermatologists, d -> d.getNIC().equals(dermatologist.getNIC()));
        if (existingDermatologist != null){
            int index = dermatologists.indexOf(existingDermatologist);
            dermatologists.set(index, dermatologist);
        }
    }

    public void deleteDermatologist(Dermatologist dermatologist){
        Dermatologist existingDermatologist = Utils.findInList(dermatologists, d -> d.getNIC().equals(dermatologist.getNIC()));
        if (existingDermatologist != null) {
            dermatologists.remove(existingDermatologist);
        }
    }
}
