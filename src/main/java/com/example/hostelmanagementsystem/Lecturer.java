package com.example.hostelmanagementsystem;

public class Lecturer extends Person{
    private String lecturerID;
    private String lecturerEmail;
    private String academicCert;
    protected Lecturer(){
        this("unknown","unknown","unknown","unknown",
                "unknown","unknown","unknown","unknown");
    }
    protected Lecturer(
            String name, String gender,String address,String phoneNumber,String emergencyContact,
            String lecturerID,String lecturerEmail,String academicCert){
        super(name, gender,address, phoneNumber,emergencyContact);
        this.lecturerID =lecturerID;
        this.lecturerEmail =lecturerEmail;
        this.academicCert = academicCert;
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

    @Override
    public String toString() {
        return super.toString() +
                "\nLecturer{" +
                "lecturerID='" + lecturerID + '\'' +
                ", lecturerEmail='" + lecturerEmail + '\'' +
                '}';
    }
}
