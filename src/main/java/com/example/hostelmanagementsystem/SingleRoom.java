package com.example.hostelmanagementsystem;

public class SingleRoom extends Room{
    private boolean isLive;
    private Person person;
    private String roomType;
    protected SingleRoom(){
        isLive = false;
        roomType = "unknown";
    }
    protected SingleRoom(String roomNumber,double roomPrice){
        super(roomNumber,roomPrice);
        // Every room is empty
        isLive = false;
        roomType = "Single Room";
    }

    @Override
    public String addPerson(Person person){
        // If have person live , then isLive equal to true
        isLive = this.person != null;
        // If false, then add a new person, because no person live
        if(!isLive){
            this.person = person;
        }
        return isLive ? "Sorry, already full.":"Successfully register";
    }
    public String removePerson(Person person){
        boolean isExist;
        // If same person, mean it is exist
        isExist = this.person == person;

        // If true, then set the person to null, because has person lived
        if(isExist){
            this.person = null;
        }
        // If have person live , then isLive equal to true
        isLive = this.person != null;
        return isExist ? "Checkout successfully": "Person no exist" ;
    }


    public String getRoomStatus(){
        return isLive? "Sorry, this room has been full": "This room still available";
    }

    @Override
    public String getPersonLived() {
        String room = "Single Room " + getRoomNumber();;
        room += isLive? " lived by " + person.getName():" is empty";
        return room;
    }

    @Override
    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        String room = getRoomNumber();
        return room;
    }
}
