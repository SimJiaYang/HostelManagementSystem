package com.example.hostelmanagementsystem;

public class Lecturer extends Person implements Price {
    private final String PHD = "PHD";
    private final String MASTER = "MASTER";
    private final String DEGREE = "DEGREE";
    private String lecturerID;
    private String lecturerEmail;
    private String academicCert;

    protected Lecturer() {
        this("unknown", "unknown", "unknown", "unknown",
                "unknown", "unknown", "unknown", 0);
    }

    protected Lecturer(
            String name, String gender, String address, String phoneNumber, String emergencyContact,
            String lecturerID, String lecturerEmail, int academicCertNumber) {
        super(name, gender, address, phoneNumber, emergencyContact);
        this.lecturerID = lecturerID;
        this.lecturerEmail = lecturerEmail;
        this.academicCert = validateAcademicCert(academicCertNumber);
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

    public String getAcademicCert() {
        return academicCert;
    }

    public String validateAcademicCert(int academicCert) {
        String cert = "Degree";
        if (academicCert == 1) {
            cert = PHD;
        } else if (academicCert == 2) {
            cert = MASTER;
        } else {
            cert = DEGREE;
        }
        return cert;
    }

    @Override
    public double getTotalPrice(int duration, Room room) {
        boolean isLive = super.isLiveHostel();
        double getRoomPrice = room.getRoomPrice();
        getRoomPrice = duration == 14 ? getRoomPrice * 2 : getRoomPrice;
        // ROOM per price is shot sem price
        if (isLive) {
            if (academicCert.equals(PHD)) {
                getRoomPrice = getRoomPrice * 0.75;
            } else if (academicCert.equals(MASTER)) {
                getRoomPrice = getRoomPrice * 0.85;
            } else if (academicCert.equals(DEGREE)) {
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
