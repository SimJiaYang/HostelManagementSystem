package com.example.hostelmanagementsystem;

public class Student extends Person implements Price {
    private String studentEmail;
    private boolean isFreshMan;

    /**
     * Empty student constructor
     */
    protected Student() {
        this("-","-",  "-", "-","-",
                "-", "-", false);
    }

    /**
     * Parameterized Student Constructor
     * @param id - Student ID
     * @param name - Student name
     * @param gender - Student gender
     * @param address - Student address
     * @param phoneNumber - Student phone number
     * @param emergencyContact - Student emergency contact
     * @param studentEmail - Student email
     * @param isFreshMan - Student is freshman or not
     */
    protected Student(
            String id,String name, String gender, String address, String phoneNumber, String emergencyContact
            , String studentEmail, boolean isFreshMan) {
        super(id,name, gender, address, phoneNumber, emergencyContact);
        this.studentEmail = studentEmail;
        this.isFreshMan = isFreshMan;
    }

    /**
     * Return the Student email
     * @return Student email
     */
    public String getStudentEmail() {
        return studentEmail;
    }

    /**
     * Return the information about either this student is freshman or not
     * @return To confirm either this student is freshman or not
     */
    public boolean isFreshMan() {
        return isFreshMan;
    }

    /**
     * Set the freshman status of the student
     * @param freshMan - Set this student either is freshman or not
     */
    public void setFreshMan(boolean freshMan) {
        isFreshMan = freshMan;
    }

    /**
     * Set the email of the student
     * @param studentEmail - Set student email
     */
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }


    /**
     * Get the hostel price of the student
     * @param duration - Semester
     * @return Total price of room after discount for student
     */
    @Override
    public double getTotalPrice(int duration) {
        boolean isLive = super.isLiveHostel();
        double getRoomPrice = dbManagement.getRoomPrice(super.getRoom());
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
     * Print out the student basic information
     * @return Print out student information
     */
    @Override
    public String toString() {
        return "Student" +
                super.toString() +
                "\nStudent Email:" + studentEmail +
                "\nFreshman" + isFreshMan;
    }
}


