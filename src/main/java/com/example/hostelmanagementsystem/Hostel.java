package com.example.hostelmanagementsystem;

public abstract class Hostel {
    int capacity;
    protected Hostel(){
        this(1);
    }
    protected Hostel(int capacity) {
        this.capacity = capacity;
    }
    public abstract int getCapacity();
    public abstract String toString();
}
