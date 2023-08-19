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
     * @param hostelID - Hostel ID
     * @param capacitySingleRoom - Capacity of Single room
     * @param capacityTripleRoom - Capacity of Triple Room
     * @param singleRoom - ArrayList single room
     * @param tripleRoom - ArrayList triple room
     */
    protected Hostel(String hostelID,int capacitySingleRoom,int capacityTripleRoom,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom) {
        this.capacitySingleRoom = capacitySingleRoom;
        this.capacityTripleRoom = capacityTripleRoom;
        this.singleRoom = singleRoom;
        this.tripleRoom = tripleRoom;
    }

    /**
     * @return Hostel ID
     */
    public String getHostelID() {
        return hostelID;
    }

    /**
     * @return Capacity of Single room
     */
    public int getCapacitySingleRoom(){
        return capacitySingleRoom;
    };

    /**
     * @return Capacity of Triple room
     */
    public int getCapacityTripleRoom(){
        return capacityTripleRoom;
    };

    /**
     * @param room - Single Room object add to Hostel
     * @return Add successful or not
     */
    public boolean addSingleRoom(Room room) {
        // If single room size is smaller than total capacity, add it
        if(singleRoom.size() <  capacitySingleRoom){
            singleRoom.add(room);
            return true;
        }
        return false;
    }

    /**
     * @param room - Triple Room object add to Hostel
     * @return Add successful or not
     */
    public boolean addTripleRoom(Room room) {
        if(tripleRoom.size() <  capacityTripleRoom){
            tripleRoom.add(room);
            return true;
        }
        return false;
    }

    /**
     * @param room - Single Room object remove from Hostel
     * @return Remove successful or not
     */
    public boolean removeSingleRoom(Room room) {
        if(singleRoom.contains(room)){
            singleRoom.remove(room);
            return true;
        }
        return false;
    }

    /**
     * @param room -  - Triple Room object add to Hostel
     * @return Remove successful or not
     */
    public boolean removeTripleRoom(Room room) {
        if(tripleRoom.contains(room)){
            tripleRoom.remove(room);
            return true;
        }
        return false;
    }

    /**
     * @return All single room list
     */
    public ArrayList<SingleRoom> getSingleRoom() {
        ArrayList<Room> room = this.singleRoom;
        ArrayList<SingleRoom> singleRooms = new ArrayList<SingleRoom>();
        for(int i = 0; i < room.size(); i++) {
            if(room.get(i) instanceof SingleRoom){
                singleRooms.add((SingleRoom)room.get(i));
            }
        }
        return singleRooms;
    }

    /**
     * @return All triple room list
     */
    public ArrayList<TripleRoom> getTripleRoom() {
        ArrayList<Room> room = this.tripleRoom;
        ArrayList<TripleRoom> tripleRooms = new ArrayList<TripleRoom>();
        for(int i = 0; i < room.size(); i++) {
            if(room.get(i) instanceof TripleRoom){
                tripleRooms.add((TripleRoom)room.get(i));
            }
        }
        return tripleRooms;
    }

    /**
     * @return Hostel information
     */
    @Override
    public String toString() {
        return  "\nSingle Room: " + singleRoom.toString() +
                "\nTriple Room: " + tripleRoom.toString() +
                "\nSingle Room Capacity: " + capacitySingleRoom +
                "\nTriple Room Capacity: " + capacityTripleRoom
                ;
    }
}
