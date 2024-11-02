package model;

public class Person {
    private String NIC;
    private String name;
    private String email;
    private int telephoneNumber;

    Person(String NIC, String name, String email, int telephoneNumber){
        setNIC(NIC);
        setName(name);
        setEmail(email);
        setTelephoneNumber(telephoneNumber);
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNIC() {
        return NIC;
    }
    public int getTelephoneNumber() {
        return telephoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}
