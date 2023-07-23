package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class OldHostel extends Hostel{
    private int TOTAL_SINGLE_ROOMS;
    private int TOTAL_TRIPLE_ROOMS;
    protected OldHostel(){
        this(0,new ArrayList<Person>(),new ArrayList<Room>(),new ArrayList<Room>() );
    }
    protected OldHostel(int capacity,ArrayList<Person> occupants,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom){
        super(capacity,occupants,singleRoom,tripleRoom);
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
