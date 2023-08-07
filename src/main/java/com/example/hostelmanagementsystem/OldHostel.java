package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class OldHostel extends Hostel{

    // Empty constructor
    protected OldHostel(){
        this("unknown",0,0,new ArrayList<Room>(),new ArrayList<Room>() );
    }

    protected OldHostel(String hostelID,int capacitySingleRoom,int capacityTripleRoom,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom){
        super(hostelID,capacitySingleRoom,capacityTripleRoom,singleRoom,tripleRoom);
    }

    @Override
    public String toString() {
        return "\nOld Hostel" + super.toString();
    }
}
