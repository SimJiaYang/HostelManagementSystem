package com.example.hostelmanagementsystem;

public abstract class Room{
    private String roomNumber;
    protected Room(String roomNumber){
        this.roomNumber = roomNumber;
    }
    public String getRoomNumber() {
        return roomNumber;
    }

    public abstract String addPerson(Person person);
    public abstract String removePerson(Person person);
}
