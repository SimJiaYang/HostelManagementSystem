package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public abstract class Hostel{
    private ArrayList<Room> singleRoom;
    private ArrayList<Room> tripleRoom;
    int capacitySingleRoom;
    int capacityTripleRoom;
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

    public boolean addSingleRoom(Room room) {
        // If single room size is smaller than total capacity, add it
        if(singleRoom.size() <  capacitySingleRoom){
            singleRoom.add(room);
            return true;
        }
        return false;
    }

    public boolean addTripleRoom(Room room) {
        if(tripleRoom.size() <  capacityTripleRoom){
            tripleRoom.add(room);
            return true;
        }
        return false;
    }

    public boolean removeSingleRoom(Room room) {
        if(singleRoom.contains(room)){
            singleRoom.remove(room);
            return true;
        }
        return false;
    }

    public boolean removeTripleRoom(Room room) {
        if(tripleRoom.contains(room)){
            tripleRoom.remove(room);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "singleRoom=" + singleRoom.toString() +
                ", tripleRoom=" + tripleRoom.toString() +
                ", capacitySingleRoom=" + capacitySingleRoom +
                ", capacityTripleRoom=" + capacityTripleRoom +
                '}';
    }
}
