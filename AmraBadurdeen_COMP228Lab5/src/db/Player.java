package db;

public class Player {
    private int id;
    private String firstName, lastName, address, postalCode, province, phoneNumber;

    public Player(int id, String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.province = province;
        this.phoneNumber = phoneNumber;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getPostalCode() { return postalCode; }
    public String getProvince() { return province; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAddress(String address) { this.address = address; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public void setProvince(String province) { this.province = province; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
