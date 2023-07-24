package com.example.hostelmanagementsystem;

public abstract class Room{
    private String roomNumber;
    private double roomPrice;
    protected Room(String roomNumber,double roomPrice){
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public double getRoomPrice() {
        return roomPrice;
    }
    public void setRoomPrice(double roomPrice){
        this.roomPrice = roomPrice;
    };
    public abstract String addPerson(Person person);
    public abstract String removePerson(Person person);
    public abstract String getPersonLived();
    public abstract String getRoomType();
}
