package com.example.hostelmanagementsystem;

public class OldHostel extends Hostel{
    protected OldHostel(){
        this(0);
    }
    protected OldHostel(int capacity){
        super(capacity);
    }

    @Override
    public int getCapacity() {
        return super.capacity;
    }

    @Override
    public String toString() {
        return null;
    }
}
