package com.example.hostelmanagementsystem;

public class Student extends Person{
    private String studentID;
    private String studentEmail;
    protected Student(){
        this("unknown","unknown","unknown","unknown",
                "unknown","unknown","unknown");
    }
    protected Student(
            String name, String gender,String address,String phoneNumber,String emergencyContact,
            String studentID, String studentEmail){
        super(name, gender,address, phoneNumber,emergencyContact);
        this.studentID = studentID;
        this.studentEmail = studentEmail;
    }
    public String getStudentID() {
        return studentID;
    }
    public String getStudentEmail() {
        return studentEmail;
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
