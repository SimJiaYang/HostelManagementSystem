package com.example.hostelmanagementsystem;

public class NewHostel extends Hostel{
    protected NewHostel(int capacity){
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
