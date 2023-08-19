package com.example.hostelmanagementsystem;

public interface Price {

    /**
     * @param duration - Long or short semester
     * @param room - Room type
     * @return Total price
     */
    public abstract double getTotalPrice(int duration,Room room);
}
