package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public abstract class Hostel{
    private ArrayList<Room> singleRoom;
    private ArrayList<Room> tripleRoom;
    private int capacitySingleRoom;
    private int capacityTripleRoom;

    // Empty constructor
    protected Hostel(){
        this(0,0,new ArrayList<Room>(),new ArrayList<Room>() );
    }

    protected Hostel(int capacitySingleRoom,int capacityTripleRoom,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom) {
        this.capacitySingleRoom = capacitySingleRoom;
        this.capacityTripleRoom = capacityTripleRoom;
        this.singleRoom = singleRoom;
        this.tripleRoom = tripleRoom;
    }
    public int getCapacitySingleRoom(){
        return capacitySingleRoom;
    };

    public int getCapacityTripleRoom(){
        return capacityTripleRoom;
    };

    // Add Single room for hostel
    public boolean addSingleRoom(Room room) {
        // If single room size is smaller than total capacity, add it
        if(singleRoom.size() <  capacitySingleRoom){
            singleRoom.add(room);
            return true;
        }
        return false;
    }
    // Add Triple room for hostel
    public boolean addTripleRoom(Room room) {
        if(tripleRoom.size() <  capacityTripleRoom){
            tripleRoom.add(room);
            return true;
        }
        return false;
    }

    // Remove Single room for hostel
    public boolean removeSingleRoom(Room room) {
        if(singleRoom.contains(room)){
            singleRoom.remove(room);
            return true;
        }
        return false;
    }
    // Remove Triple room for hostel
    public boolean removeTripleRoom(Room room) {
        if(tripleRoom.contains(room)){
            tripleRoom.remove(room);
            return true;
        }
        return false;
    }

    //get all single room
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
    //get all triple room
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

    @Override
    public String toString() {
        return  "\nSingle Room: " + singleRoom.toString() +
                "\nTriple Room: " + tripleRoom.toString() +
                "\nSingle Room Capacity: " + capacitySingleRoom +
                "\nTriple Room Capacity: " + capacityTripleRoom
                ;
    }
}
