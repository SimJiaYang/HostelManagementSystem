package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class NewHostel extends Hostel{
    protected NewHostel(){
        this(0,new ArrayList<Person>(),new ArrayList<Room>(),new ArrayList<Room>() );
    }
    protected NewHostel(int capacity,ArrayList<Person> occupants,ArrayList<Room> singleRoom,ArrayList<Room> tripleRoom){
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
