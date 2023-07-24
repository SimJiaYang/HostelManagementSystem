package com.example.hostelmanagementsystem;

public class Person {
    private String name;
    private String address;
    private String gender;
    private String phoneNumber;
    private String emergencyContact;
    private boolean isLiveHostel;
    private String roomNumber;
    protected Person(){
        this("unknown","unknown","unknown","unknown","unknown");
    }
    protected Person(String name, String gender,String address, String phoneNumber,String emergencyContact) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emergencyContact = emergencyContact;
        isLiveHostel = false;
        roomNumber = null;
    }
    // Get person room number, if available then show, else show error message
    public String getRoomNumber() {
        if(roomNumber == null){
            return "This person don't live hostel";
        }
        return roomNumber;
    }
    // When student register, set the room number
    public void setRoomNumber(String roomNumber) {
        isLiveHostel = true;
        this.roomNumber = roomNumber;
    }
    // Since the student checkout, remove room number
    public void removeRoomNumber() {
        isLiveHostel = false;
        this.roomNumber = null;
    }
    public boolean isLiveHostel() {
        return isLiveHostel;
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
