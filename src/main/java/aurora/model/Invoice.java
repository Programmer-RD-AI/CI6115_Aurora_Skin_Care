// Invoice.java
package model;

import java.util.List;

public class Invoice {
    private Person person;
    private List<Treatment> treatments;
    private double totalPrice = 0.0;
    private double taxPercentage = 2;

    public Invoice(Person person, List<Treatment> treatments) {
        this.person = person;
        this.treatments = treatments;
        calculateTotal();
    }

    public double calculateTotal() {
        for (Treatment treatment : treatments) {
            totalPrice += treatment.getPrice();
        }
        totalPrice += totalPrice * (taxPercentage / 100.0);
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < treatments.size(); i++) {
            sb.append("Treatment ").append(i + 1).append(" ").append(treatments.get(i).getName())
                    .append(" :").append(treatments.get(i).getPrice()).append("\n");
        }
        return sb.toString();
    }

    public void reserveAppointmentPayment(Integer initialPayment) {
        if (initialPayment == null) {
            initialPayment = 500;
        }
        this.totalPrice -= initialPayment;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
