package com.example.hostelmanagementsystem;

public class Student extends Person implements Price {
    private String studentEmail;
    private boolean isFreshMan;

    /**
     * Empty student constructor
     */
    protected Student() {
        this("unknown","unknown",  "unknown", "unknown","unknown",
                "unknown", "unknown", "unknown", false);
    }

    /**
     * @param id - Student ID
     * @param name - Student name
     * @param gender - Student gender
     * @param address - Student address
     * @param phoneNumber - Student phone number
     * @param emergencyContact - Student emergency contact
     * @param roomNumber - Student room number
     * @param studentEmail - Student email
     * @param isFreshMan - Student is freshman or not
     */
    protected Student(
            String id,String name, String gender, String address, String phoneNumber, String emergencyContact
            ,String roomNumber, String studentEmail, boolean isFreshMan) {
        super(id,name, gender, address, phoneNumber, emergencyContact,roomNumber);
        this.studentEmail = studentEmail;
        this.isFreshMan = isFreshMan;
    }

    /**
     * @return Student email
     */
    public String getStudentEmail() {
        return studentEmail;
    }

    /**
     * @return To confirm either this student is freshman or not
     */
    public boolean isFreshMan() {
        return isFreshMan;
    }

    /**
     * @param freshMan - Set this student either is freshman or not
     */
    public void setFreshMan(boolean freshMan) {
        isFreshMan = freshMan;
    }

    /**
     * @param studentEmail - Set student email
     */
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }


    /**
     * @param duration - Semester
     * @param room - Room object
     * @return Total price of room after discount for student
     */
    @Override
    public double getTotalPrice(int duration,Room room) {
        boolean isLive = super.isLiveHostel();
        double getRoomPrice = room.getRoomPrice();
        getRoomPrice = duration == 14 ? getRoomPrice * 2 : getRoomPrice;
        if(isLive) {
            if(isFreshMan){
               getRoomPrice *= 0.8;
            }
        }else{
            getRoomPrice = 0;
        }
        return getRoomPrice;
    }

    /**
     * @return Print out student information
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nStudent{" +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }

}


