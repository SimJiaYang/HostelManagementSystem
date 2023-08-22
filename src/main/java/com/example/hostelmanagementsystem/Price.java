package com.example.hostelmanagementsystem;

public interface Price {

    /**
     * @param duration - Long or short semester
     * @return Total price
     */
    public abstract double getTotalPrice(int duration);
}
