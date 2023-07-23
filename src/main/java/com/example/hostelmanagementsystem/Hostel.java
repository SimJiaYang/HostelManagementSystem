package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public abstract class Hostel{
    ArrayList<Person> occupants;
    ArrayList<Room> singleRoom;
    ArrayList<Room> tripleRoom;
    int capacity;
    protected Hostel(){
        this(0,new ArrayList<Person>(),new ArrayList<Room>(),new ArrayList<Room>() );
    }
    protected Hostel(int capacity,ArrayList<Person> occupants,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom) {
        this.capacity = capacity;
        this.occupants = occupants;
        this.singleRoom = singleRoom;
        this.tripleRoom = tripleRoom;
    }
    public abstract int getCapacity();

    public boolean addSingleRoom(Room room) {
        return singleRoom.add(room);
    }

    public boolean addTripleRoom(Room room) {
        return tripleRoom.add(room);
    }

    public boolean addOccupants(Person person) {
        return occupants.add(person);
    }

    public boolean removeSingleRoom(Room room) {
        return singleRoom.remove(room);
    }

    public boolean removeTripleRoom(Room room) {
        return tripleRoom.remove(room);
    }

    public boolean removeOccupants(Person person) {
        return occupants.remove(person);
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "occupants=" + occupants.toString() +
                ", singleRoom=" + singleRoom.toString() +
                ", tripleRoom=" + tripleRoom.toString() +
                ", capacity=" + capacity+
                '}';
    }
}
