package com.example.hostelmanagementsystem;

public abstract class Room{
    private String roomNumber;
    private double roomPrice;

    /**
     * Empty constructor for creating room
     */
    protected Room(){
        this("unknown",0);
    }

    /**
     * @param roomNumber - Room number
     * @param roomPrice - Room price
     */
    protected Room(String roomNumber,double roomPrice){
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
    }

    /**
     * @return Room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * @return Room price
     */
    public double getRoomPrice() {
        return roomPrice;
    }

    /**
     * @param roomPrice - Set room price
     */
    public void setRoomPrice(double roomPrice){
        this.roomPrice = roomPrice;
    };

    /**
     * @param id - Person ID for adding to room
     * @return Add successful or not
     */
    public abstract boolean addPerson(String id);

    /**
     * @param id - Person ID to remove from room
     * @return Remove successful or not
     */
    public abstract boolean removePerson(String id);

    /**
     * @return Room basic information
     */
    public String toString() {
        String room = getRoomNumber();
        return room;
    }

}
