package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class NewHostel extends Hostel{

    // Empty constructor
    protected NewHostel(){
        this(0,0,new ArrayList<Room>(),new ArrayList<Room>() );
    }

    protected NewHostel(int capacitySingleRoom,int capacityTripleRoom,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom){
        super(capacitySingleRoom,capacityTripleRoom,singleRoom,tripleRoom);
    }

    @Override
    public String toString() {
        return "\nNew Hostel" +
                super.toString();
    }
}
