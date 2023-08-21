package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class TripleRoom extends Room {
    private String roomType;

    /**
     * Empty constructor for creating a new triple room
     */
    protected TripleRoom(){
        roomType = "-";
    }

    /**
     * Parameterized Constructor for creating a new triple room
     * @param roomNumber - Triple room number
     */
    protected TripleRoom(String roomNumber){
        super(roomNumber);
        roomType = "Triple Room";
    }

    /**
     * Show the information of the triple room
     * @return Triple room basic information
     */
    @Override
    public String toString() {
        return "\nRoom Number : " + super.getRoomNumber()
                + " Room Type: " + roomType;
    }
}
