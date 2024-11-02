package service;

import model.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointmentList = new ArrayList<>();

    public void addAppointment(Appointment appointment){
        appointmentList.add(appointment);
    }

    public void updateAppointment(Appointment appointment){
        for (Appointment appointmentIter : appointmentList){
            if (appointmentIter.getAppointmentID() == appointment.getAppointmentID()){
                appointmentList.set(appointmentList.indexOf(appointmentIter), appointment);
                return;
            }
        }
    }


    public void updateAppointment(int idx, Appointment newAppointment){
        appointmentList.set(idx, newAppointment);
    }

    public void deleteAppointment(int idx){
        appointmentList.remove(idx);
    }

    public void deleteAppointment(Appointment appointment){
        appointmentList.remove(appointment);
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
}
