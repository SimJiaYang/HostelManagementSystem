package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class TripleRoom extends Room {
    private ArrayList<String> id;
    private boolean isFull;
    private String roomType;

    // Empty constructor
    protected TripleRoom(){
        isFull = false;
        roomType = "unknown";
    }

    protected TripleRoom(String roomNumber,double roomPrice){
        super(roomNumber,roomPrice);
        // Set the default room non-person live
        isFull = false;
        roomType = "Triple Room";
    }

    // Add the person to the room
    @Override
    public boolean addPerson(String id){
        // If have more than or equal 3 person live , then isLive equal to true
        isFull = this.id.size() >= 3;
        // If false, then add a new person, since not full yet
        if(!isFull){
            this.id.add(id);
        }
        return isFull;
    }

    // Remove person from the room
    public boolean removePerson(String id){
        boolean isExist;
        // If have person contained in room , then isExist equal to true
        isExist= this.id.contains(id);
        // If isExist is true, then remove that person
        if(isExist){
            this.id.remove(id);
        }
        // If persons,size not equal or greater than 3, still have people lived
        isFull = this.id.size() >= 3;
        return isExist;
    }

    public boolean getIsFull(){
        return isFull;
    }


}
