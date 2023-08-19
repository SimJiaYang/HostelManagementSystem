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
     * Empty constrcutor for person
     */
    protected Person(){
        this("","unknown","unknown","unknown","unknown","unknown","unknown");
    }

    /**
     * @param id - ID of the person
     * @param name - Name of the person
     * @param gender - Gender of the person
     * @param address - Address of the person
     * @param phoneNumber - Phone number of the person
     * @param emergencyContact - Emergency contact
     * @param roomNumber - Room number of the person
     */
    protected Person(String id,String name, String gender,String address, String phoneNumber,String emergencyContact,String roomNumber) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emergencyContact = emergencyContact;
        this.id = id;
        // Set the default person no live hostel
        isLiveHostel = false;
        this.roomNumber = roomNumber;
    }

    /**
     * @return Get person ID
     */
    public String getId() {
        return id;
    }


    /**
     * @return Room number
     */
    public String getRoomNumber() {
        if(roomNumber == null){
            return "This person don't live hostel";
        }
        return roomNumber;
    }

    /**
     * @param roomNumber - Set room number
     */
    public void setRoomNumber(String roomNumber) {
        isLiveHostel = true;
        this.roomNumber = roomNumber;
    }


    /**
     *  Remove room number
     */
    public void removeRoomNumber() {
        isLiveHostel = false;
        this.roomNumber = null;
    }

    /**
     * @return Get either this person is live hostel or not
     */
    public boolean isLiveHostel() {
        return isLiveHostel;
    }

    /**
     * @return Get name
     */
    public String getName() { return name; }

    /**
     * @param name - Set name
     */
    public void setName(String name) { this.name = name; }

    /**
     * @return Get gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender - Set gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return Get address
     */
    public String getAddress() { return address; }

    /**
     * @param address - Set address
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * @return Person phone number
     */
    public String getPhoneNumber() { return phoneNumber;}

    /**
     * @param phoneNumber - Set phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return Person emergency number
     */
    public String getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * @param emergencyContact - Set person emergency number
     */
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    /**
     * @return Print out person information
     */
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
