package com.example.hostelmanagementsystem;

public class SingleRoom extends Room{
    private String roomType;

    /**
     * Empty constructor for creating a single room
     */
    protected SingleRoom(){
        roomType = "-";
    }

    /**
     * Parameterized the constructor of the single room
     * @param roomNumber - Single room number
     */
    protected SingleRoom(String roomNumber){
        super(roomNumber);
        roomType = "Single Room";
    }


    /**
     * Show the information about the room
     * @return Single room basic information
     */
    @Override
    public String toString() {
        return "\nRoom Number : " + super.getRoomNumber()
                + " Room Type: " + roomType;
    }
}
