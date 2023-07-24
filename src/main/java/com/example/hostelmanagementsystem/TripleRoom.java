package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class TripleRoom extends Room {
    ArrayList<Person> persons;
    boolean isLive;
    protected TripleRoom(String roomNumber){
        super(roomNumber);
        isLive = false;
    }
    @Override
    public String addPerson(Person person){
        // If have more than or equal 3 person live , then isLive equal to true
        isLive = this.persons.size() >= 3;
        // If false, then add a new person, since not full yet
        if(!isLive){
            this.persons.add(person);
        }
        return isLive ? "Sorry, already full.":"Successfully register" ;
    }
    public String removePerson(Person person){
        boolean isExist;
        // If have person contained in room , then isExist equal to true
        isExist= this.persons.contains(person);
        // If isExist is true, then remove that person
        if(isExist){
            this.persons.remove(person);
        }
        // If persons,size not equal to 0, mean still have people live
        isLive = persons.size() != 0;
        return isExist? "Checkout successfully": "Person no exist" ;
    }

    public String getRoomStatus(){
        return isLive? "Sorry, this room has been full": "This room still available";
    }

    @Override
    public String toString() {
        String room = "Triple Room " + getRoomNumber();
        String person = "";
        if(persons.size() == 0){
            person = "is empty";
            room += person;
        }else{
            room += "is lived by ";
          for(Person p : persons) {
              person += p.getName() + ",";
          }
          room += person;
        }
        return room;
    }

}
