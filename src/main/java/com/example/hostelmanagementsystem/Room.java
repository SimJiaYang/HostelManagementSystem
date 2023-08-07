package com.example.hostelmanagementsystem;

public abstract class Room{
    private String roomNumber;
    private double roomPrice;

    // Empty constructor
    protected Room(){
        this("unknown",0);
    }

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

    public abstract boolean addPerson(String id);

    public abstract boolean removePerson(String id);

    public String toString() {
        String room = getRoomNumber();
        return room;
    }

}
