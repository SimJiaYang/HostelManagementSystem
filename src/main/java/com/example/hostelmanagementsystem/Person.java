package com.example.hostelmanagementsystem;

public class Person {
    String name;
    String address;
    String gender;
    String phoneNumber;
    String emergencyContact;
    protected Person(){
        this("unknown","unknown","unknown","unknown","unknown");
    }
    protected Person(String name, String gender,String address, String phoneNumber,String emergencyContact) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emergencyContact = emergencyContact;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                '}';
    }
}
