package com.example.hostelmanagementsystem;

public class Lecturer extends Person implements Price {
    private final String DEAN = "DEAN";
    private final String HOD = "HOD";
    private final String PROFESSOR = "PROFESSOR";
    private String lecturerID;
    private String lecturerEmail;
    private String position;

    // Empty constructor
    protected Lecturer() {
        this("unknown", "unknown", "unknown", "unknown",
                "unknown", "unknown", "unknown", 0);
    }

    protected Lecturer(
            String name, String gender, String address, String phoneNumber, String emergencyContact,
            String lecturerID, String lecturerEmail, int positionNumber) {
        super(name, gender, address, phoneNumber, emergencyContact);
        this.lecturerID = lecturerID;
        this.lecturerEmail = lecturerEmail;
        this.position = validatePosition(positionNumber);
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }

    public String getLecturerEmail() {
        return lecturerEmail;
    }

    public String getPosition() {
        return position;
    }

    // Get lecturer position
    public String validatePosition(int position) {
        String positionDetail = "";
        if (position == 1) {
            positionDetail = DEAN;
        } else if (position == 2) {
            positionDetail = HOD;
        } else {
            positionDetail = PROFESSOR;
        }
        return positionDetail;
    }

    // Get total price for lecturer
    @Override
    public double getTotalPrice(int duration, Room room) {
        boolean isLive = super.isLiveHostel();
        double getRoomPrice = room.getRoomPrice();
        getRoomPrice = duration == 14 ? getRoomPrice * 2 : getRoomPrice;
        // ROOM per price is shot sem price
        if (isLive) {
            if (position.equals(DEAN)) {
                getRoomPrice = getRoomPrice * 0.75;
            } else if (position.equals(HOD)) {
                getRoomPrice = getRoomPrice * 0.85;
            } else if (position.equals(PROFESSOR)) {
                getRoomPrice = getRoomPrice * 0.95;
            }
        } else {
            getRoomPrice = 0;
        }
        return getRoomPrice;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLecturer{" +
                "lecturerID='" + lecturerID + '\'' +
                ", lecturerEmail='" + lecturerEmail + '\'' +
                '}';

    }
}
