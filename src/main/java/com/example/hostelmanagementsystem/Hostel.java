package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public abstract class Hostel{
    private String hostelID;
    private ArrayList<Room> singleRoom;
    private ArrayList<Room> tripleRoom;
    private int capacitySingleRoom;
    private int capacityTripleRoom;

    /**
     * Empty constructor for hostel creation
     */
    protected Hostel(){
        this("unknown",0,0,new ArrayList<Room>(),new ArrayList<Room>() );
    }

    /**
     * Parameterized the constructor of the hostel
     * @param hostelID - Hostel ID
     * @param capacitySingleRoom - Capacity of Single room
     * @param capacityTripleRoom - Capacity of Triple Room
     * @param singleRoom - ArrayList single room
     * @param tripleRoom - ArrayList triple room
     */
    protected Hostel(String hostelID,int capacitySingleRoom,int capacityTripleRoom,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom) {
        this.hostelID = hostelID;
        this.capacitySingleRoom = capacitySingleRoom;
        this.capacityTripleRoom = capacityTripleRoom;
        this.singleRoom = singleRoom;
        this.tripleRoom = tripleRoom;
    }

    /**
     * Get the hostel ID
     * @return Hostel ID
     */
    public String getHostelID() {
        return hostelID;
    }

    /**
     * Get the capacity of the single room of the hostel
     * @return Capacity of Single room
     */
    public int getCapacitySingleRoom(){
        return capacitySingleRoom;
    };

    /**
     * Get the capacity of the triple room of the hostel
     * @return Capacity of Triple room
     */
    public int getCapacityTripleRoom(){
        return capacityTripleRoom;
    };

    /**
     * Add a new single room to the hostel
     * @param room - Single Room object add to Hostel
     * @return Add successful or not
     */
    public boolean addSingleRoom(Room room) {
        for(int i = 0; i < singleRoom.size(); i++) {
            if(singleRoom.get(i).getRoomNumber().equals(room.getRoomNumber())){
                return false;
            }
        }
        // If single room size is smaller than total capacity, add it
        if(singleRoom.size() <  capacitySingleRoom){
            singleRoom.add(room);
            return true;
        }
        return false;
    }

    /**
     * Add a new triple room to the hostel
     * @param room - Triple Room object add to Hostel
     * @return Add successful or not
     */
    public boolean addTripleRoom(Room room) {
        for(int i = 0; i < tripleRoom.size(); i++) {
            if(tripleRoom.get(i).getRoomNumber().equals(room.getRoomNumber())){
                return false;
            }
        }
        if(tripleRoom.size() <  capacityTripleRoom){
            tripleRoom.add(room);
            return true;
        }
        return false;
    }

    /**
     * Remove a single room from the hostel
     * @param roomID - Single Room object remove from Hostel
     * @return Remove successful or not
     */
    public boolean removeSingleRoom(String roomID) {
        for(int i = 0; i < singleRoom.size(); i++) {
            if(singleRoom.get(i).getRoomNumber().equals(roomID)){
                singleRoom.remove(singleRoom.get(i));
                return true;
            }
        }
        return false;
    }

    /**
     * Remove a triple room from the hostel
     * @param roomID - Triple Room object add to Hostel
     * @return Remove successful or not
     */
    public boolean removeTripleRoom(String roomID) {
        for(int i = 0; i < tripleRoom.size(); i++) {
            if(tripleRoom.get(i).getRoomNumber().equals(roomID)){
                tripleRoom.remove(tripleRoom.get(i));
                return true;
            }
        }
        return false;
    }

    /**
     * Show all the single room in the hostel
     * @return All single room list
     */
    public String getSingleRoom() {
        String output = "";
        for(int i = 0; i < singleRoom.size(); i++) {
                output += "|"+ singleRoom.get(i).getRoomNumber() + "|  ";
        }
        return output;
    }

    /**
     * Show all the triple room in the hostel
     * @return All triple room list
     */
    public String getTripleRoom() {
        String output = "";
        for(int i = 0; i < tripleRoom.size(); i++) {
            output += "|"+ tripleRoom.get(i).getRoomNumber() + "|  ";
        }
        return output;
    }

    /**
     * Show the information about the hostel
     * @return Hostel information
     */
    @Override
    public String toString() {
        return getSingleRoom() + getTripleRoom();
    }
}
