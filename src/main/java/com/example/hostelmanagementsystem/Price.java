package com.example.hostelmanagementsystem;

public interface Price {

    // Long semester = 14 weeks
    // Short semester = 7 weeks
    // Implement in student and lecturer class
    public abstract double getTotalPrice(int duration,Room room);
}
