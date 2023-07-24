package com.example.hostelmanagementsystem;

public interface Fees {
    // Long semester = 14 weeks
    // Short semester = 7 weeks
    public abstract double getTotalPrice(int duration);
}
