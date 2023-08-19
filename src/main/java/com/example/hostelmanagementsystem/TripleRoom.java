package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class TripleRoom extends Room {
    private ArrayList<String> id;
    private boolean isFull;
    private String roomType;

    /**
     * Empty constructor for creating a new triple room
     */
    protected TripleRoom(){
        isFull = false;
        roomType = "unknown";
    }

    /**
     * @param roomNumber - Triple room number
     * @param roomPrice - Triple room price
     */
    protected TripleRoom(String roomNumber,double roomPrice){
        super(roomNumber,roomPrice);
        // Set the default room non-person live
        isFull = false;
        roomType = "Triple Room";
    }

    /**
     * @param id - Person ID for adding to the triple room
     * @return Either add successful or failure
     */
    @Override
    public boolean addPerson(String id){
        // If triple room have more than or equal 3 person live , then isLive equal to true
        isFull = this.id.size() >= 3;
        // If false, then add a new person, since not full yet
        if(!isFull){
            this.id.add(id);
        }
        return isFull;
    }

    /**
     * @param id - Person ID to remove from the triple room
     * @return Either remove successful or failure
     */
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

    /**
     * @return Either the triple room is full or not
     */
    public boolean getIsFull(){
        return isFull;
    }

    /**
     * @return Triple room basic information
     */
    @Override
    public String toString() {
        return "TripleRoom{" +
                "id=" + id +
                ", isFull=" + isFull +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}
