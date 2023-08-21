package com.example.hostelmanagementsystem;

public class Person {
    private String id;
    private String name;
    private String address;
    private String gender;
    private String phoneNumber;
    private String emergencyContact;
    private boolean isLiveHostel;
    private String roomNumber;

    /**
     * Empty constructor for person
     */
    protected Person(){
        this("-","-","-","-","-",
                "-");
    }

    /**
     * Parameterized constructor for person
     * @param id - ID of the person
     * @param name - Name of the person
     * @param gender - Gender of the person
     * @param address - Address of the person
     * @param phoneNumber - Phone number of the person
     * @param emergencyContact - Emergency contact
     */
    protected Person(String id,String name, String gender,String address, String phoneNumber,String emergencyContact) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emergencyContact = emergencyContact;
        this.id = id;
        // Set the default person no live hostel
        isLiveHostel = false;
        this.roomNumber = null;
    }

    /**
     * Get Person ID
     * @return person ID
     */
    public String getId() {
        return id;
    }


    /**
     * Get Room Number
     * @return room number
     */
    public String getRoom() {
        return isLiveHostel? roomNumber : "Not available";
    }

    /**
     * Set the room number of the person lived
     * @param roomNumber - Set room number
     */
    public void setRoom(String roomNumber) {
        isLiveHostel = true;
        this.roomNumber = roomNumber;
    }

    /**
     *  Remove room number for person
     */
    public void removeRoomNumber() {
        isLiveHostel = false;
        roomNumber = null;
    }

    /**
     * Get either this person is live hostel or not
     * @return true or false
     */
    public boolean isLiveHostel() {
        return isLiveHostel;
    }

    /**
     * Get the name of the person
     * @return name
     */
    public String getName() { return name; }

    /**
     * Set the name of the person
     * @param name - Set name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Get the gender of the person
     * @return Get gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set the gender of the person
     * @param gender - Set gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Get the address of the person
     * @return Get address
     */
    public String getAddress() { return address; }

    /**
     * Set the address of the person
     * @param address - Set address
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * Get the phone number of the person
     * @return Person phone number
     */
    public String getPhoneNumber() { return phoneNumber;}

    /**
     * Set the phone number of the person
     * @param phoneNumber - Set phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the emergency contact of the person
     * @return Person emergency number
     */
    public String getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * Set the emergency contact of the person
     * @param emergencyContact - Set person emergency number
     */
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    /**
     * Return the person information
     * @return Print out person information
     */
    @Override
    public String toString() {
        return "\n\nName: " + name +
                "\nAddress: " + address +
                "\nGender: " + gender +
                "\nPhone Number: " + phoneNumber +
                "\nEmergency Contact: " + emergencyContact +
                "\nRoom Number: " + roomNumber;
    }
}
