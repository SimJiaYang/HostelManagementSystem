package com.example.hostelmanagementsystem;

public class Room{
    private String roomNumber;
    protected Room(String roomNumber){
        this.roomNumber = roomNumber;
    }
    public String getRoomNumber() {
        return roomNumber;
    }

}
