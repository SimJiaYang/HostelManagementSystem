package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class NewHostel extends Hostel{

    /**
     * Empty constructor for creating new hostel
     */
    protected NewHostel(){
        this("unknown",0,0,new ArrayList<Room>(),new ArrayList<Room>() );
    }

    /**
     * Parameterized the constructor of the new hostel
     * @param hostelID - New Hostel ID
     * @param capacitySingleRoom - Capacity of single room
     * @param capacityTripleRoom - Capacity of triple room
     * @param singleRoom - Single room arraylist
     * @param tripleRoom - Triple room arraylist
     */
    protected NewHostel(String hostelID,int capacitySingleRoom,int capacityTripleRoom,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom){
        super(hostelID,capacitySingleRoom,capacityTripleRoom,singleRoom,tripleRoom);
    }

    /**
     * Show the information of the new hostel
     * @return New hostel basic information
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
