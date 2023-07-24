package com.example.hostelmanagementsystem;

public class Student extends Person{
    private String studentID;
    private String studentEmail;
    private boolean isFreshMan;
    protected Student(){
        this("unknown","unknown","unknown","unknown",
                "unknown","unknown","unknown",false);
    }
    protected Student(
            String name, String gender,String address,String phoneNumber,String emergencyContact,
            String studentID, String studentEmail,boolean isFreshMan){
        super(name, gender,address, phoneNumber,emergencyContact);
        this.studentID = studentID;
        this.studentEmail = studentEmail;
        this.isFreshMan = isFreshMan;
    }
    public String getStudentID() {
        return studentID;
    }
    public String getStudentEmail() {
        return studentEmail;
    }
    public boolean isFreshMan() {
        return isFreshMan;
    }
    public void setFreshMan(boolean freshMan) {
        isFreshMan = freshMan;
    }
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nStudent{" +
                "studentID='" + studentID + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}
