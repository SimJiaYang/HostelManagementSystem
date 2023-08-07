package com.example.hostelmanagementsystem;

public class SingleRoom extends Room{
    private boolean isFull;
    private String id;

    // Empty constructor
    protected SingleRoom(){
        isFull = false;
    }

    protected SingleRoom(String roomNumber,double roomPrice){
        super(roomNumber,roomPrice);
        // Every room is empty initial
        isFull = false;
    }

    // Add person to room
    @Override
    public boolean addPerson(String  id){
        // If false, then add a new person, because no full
        if(!isFull){
            this.id = id;
        }
        return isFull;
    }

    //Remove person from room
    public boolean removePerson(String id){
        boolean isExist;
        // If same person, mean it is existed
        isExist = this.id.equals(id);

        // If true, then set the person to null, because has person lived
        if(isExist){
           this.id = null;
           // If remove successfully, then set is full to falsse
           isFull = false;
        }
        return isExist;
    }

    public boolean getIsFull() {
        return isFull;
    }

}
