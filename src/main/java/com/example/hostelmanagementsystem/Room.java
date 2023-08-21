package com.example.hostelmanagementsystem;

public abstract class Room{
    private String roomNumber;

    /**
     * Empty constructor for creating room
     */
    protected Room(){
        this("-");
    }

    /**
     * Parameterize the constructor of the room
     * @param roomNumber - Room number
     */
    protected Room(String roomNumber){
        this.roomNumber = roomNumber;
    }

    /**
     * Get the number of the room
     * @return Room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Show the information about the room
     * @return Room basic information
     */
    public String toString() {
        return roomNumber;
    }

}
