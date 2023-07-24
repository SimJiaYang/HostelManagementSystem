package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class OldHostel extends Hostel{
    protected OldHostel(){
        this(0,0,new ArrayList<Room>(),new ArrayList<Room>() );
    }
    protected OldHostel(int capacitySingleRoom,int capacityTripleRoom,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom){
        super(capacitySingleRoom,capacityTripleRoom,singleRoom,tripleRoom);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
