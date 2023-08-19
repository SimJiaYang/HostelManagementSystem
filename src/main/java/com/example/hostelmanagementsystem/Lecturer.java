package com.example.hostelmanagementsystem;

public class Lecturer extends Person implements Price {
    private final String DEAN = "DEAN";
    private final String HOD = "HOD";
    private final String PROFESSOR = "PROFESSOR";
    private String lecturerEmail;
    private String position;

    /**
     * Empty Constructor for Lecturer
     */
    protected Lecturer() {
        this("unknown","unknown", "unknown","unknown","unknown",
                "unknown", "unknown", "unknown", 0);
    }


    /**
     * @param id - Lecturer ID
     * @param name - Lecturer name
     * @param gender  - Lecturer gender
     * @param address  - Lecturer address
     * @param phoneNumber  - Lecturer phone
     * @param emergencyContact  - Lecturer contact
     * @param roomNumber  - Lecturer room number
     * @param lecturerEmail  - lecturer email
     * @param positionNumber  - lecturer position
     */
    protected Lecturer(
            String id,String name, String gender, String address, String phoneNumber, String emergencyContact,String roomNumber,
            String lecturerEmail, int positionNumber) {
        super(id,name, gender, address, phoneNumber, emergencyContact,roomNumber);
        this.lecturerEmail = lecturerEmail;
        this.position = validatePosition(positionNumber);
    }

    /**
     * @param lecturerEmail - Set Lecturer Email
     */
    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }


    /**
     * @return Lecturer email
     */
    public String getLecturerEmail() {
        return lecturerEmail;
    }

    /**
     * @return Lecturer position
     */
    public String getPosition() {
        return position;
    }


    /**
     * @param position - Get lecturer position number
     * @return Lecturer position
     */
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

    /**
     * @param duration - Duration for semester
     * @param room - Room object in order to get room price
     * @return Room price after discount
     */
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

    /**
     * @return Lecturer basic information
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nLecturer{" +
                ", lecturerEmail='" + lecturerEmail + '\'' +
                '}';

    }
}
