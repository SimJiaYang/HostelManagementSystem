package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class OldHostel extends Hostel{

    /**
     * Empty constructor for creating old hostel
     */
    protected OldHostel(){
        this("unknown",0,0,new ArrayList<Room>(),new ArrayList<Room>() );
    }

    /**
     * Parameterized the constructor of the old hostel
     * @param hostelID - Old Hostel ID
     * @param capacitySingleRoom - Capacity of single room
     * @param capacityTripleRoom - Capacity of triple room
     * @param singleRoom - Single room arraylist
     * @param tripleRoom - Triple room arraylist
     */
    protected OldHostel(String hostelID,int capacitySingleRoom,int capacityTripleRoom,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom){
        super(hostelID,capacitySingleRoom,capacityTripleRoom,singleRoom,tripleRoom);
    }

    /**
     * Shows the information about the old hostel
     * @return Old hostel basic information
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
