package model;

public class Treatment {
    private String name;
    private double price;

    public Treatment(String name, double price){
        setName(name);
        setPrice(price);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
