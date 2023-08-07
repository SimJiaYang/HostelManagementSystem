package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class TestingHostelManagementSystem {
    public static void main(String[] args){
        dbConnect dbConnect = new dbConnect();
        System.out.println(dbConnect.initializeDB());

//        newHostel();
//        oldHostel();
//        registerPerson();
//        registerRoomInformation();
    }
    public static void newHostel(){
//        System.out.println("------------------------------------------------------------------------------------------------");
//        // For new hostel
//        ArrayList<Room> singleRooms = new ArrayList<Room>();
//        ArrayList<Room> tripleRooms = new ArrayList<Room>();
//        double singleRoomPrice = 800;
//        double tripleRoomPrice = 500;
//        for(int i=0;i<15;i++){
//            singleRooms.add(new SingleRoom("A" + (i+1),singleRoomPrice));
//        }
//        for(int i=0;i<15;i++){
//            tripleRooms.add(new TripleRoom("B" + (i+1),tripleRoomPrice));
//        }
//        int singleRoomSize = singleRooms.size();
//        int tripleRoomSize = tripleRooms.size();
//        Hostel hostel = new NewHostel(singleRoomSize,tripleRoomSize,singleRooms,tripleRooms);
//        System.out.println("Before remove" + hostel.toString());
//
//        // Remove room
//        Room room = singleRooms.get(0);
//        Room addRoom = new SingleRoom("Store Room",0);
//        hostel.removeSingleRoom(room);
//        hostel.addSingleRoom(addRoom);
//
//        //System.out.println(isSuccess);
//        System.out.println("\nAfter remove and Add" +hostel.toString());
//
//        //Get arraylist of single room and double room
//        System.out.println("Get arraylist of single room and double room");
//        System.out.println(hostel.getSingleRoom().toString());
//        System.out.println(hostel.getTripleRoom().toString());
    }

    public static void oldHostel(){
//        System.out.println("------------------------------------------------------------------------------------------------");
//        // For new hostel
//        ArrayList<Room> singleRooms = new ArrayList<Room>();
//        ArrayList<Room> tripleRooms = new ArrayList<Room>();
//        double singleRoomPrice = 400;
//        double tripleRoomPrice = 300;
//        for(int i=0;i<20;i++){
//            singleRooms.add(new SingleRoom("C" + (i+1),singleRoomPrice));
//        }
//        for(int i=0;i<20;i++){
//            tripleRooms.add(new TripleRoom("D" + (i+1),tripleRoomPrice));
//        }
//        int singleRoomSize = singleRooms.size();
//        int tripleRoomSize = tripleRooms.size();
//
//        Hostel hostel = new OldHostel(singleRoomSize,tripleRoomSize,singleRooms,tripleRooms);
//        System.out.println("\nBefore remove" + hostel.toString());
//        // Remove room
//        Room room = tripleRooms.get(14);
//        Room addRoom = new TripleRoom("Study Room",0);
//        hostel.removeTripleRoom(room);
//        hostel.addTripleRoom(addRoom);
////        System.out.println(isSuccess);
//        System.out.println("\nAfter remove and Add" +hostel.toString());
    }

    public static void registerPerson(){
//        System.out.println("------------------------------------------------------------------------------------------------");
//        Person person1 = new Student(
//                "John","Boy","Kulai",
//                "011-123456778","999","B2101101B","",true);
//        Person person2 = new Lecturer(
//                "David","Boy","Taman University",
//                "011-123456778","999","yc363","",1);
//        Person person3 = new Student(
//                "John2","Boy","Kulai",
//                "011-123456778","999","B2101101B","",false);
//        Person person4 = new Lecturer(
//                "David2","Boy","Taman University",
//                "011-123456778","999","yc363","",2);
//        ArrayList<Person> person = new ArrayList<Person>();
//        person.add(person1);
//        person.add(person2);
//        person.add(person3);
//        person.add(person4);
//        for(Person ps:person){
//            System.out.println(ps);
//        }
//        System.out.println("Modified Information");
//        person1.setAddress("set Address");
//        person1.setGender("set Gender");
//        person1.setName("set Name");
//        person1.setPhoneNumber("set Phone Number");
//        person1.setEmergencyContact("setEmergency Contact");
//        System.out.println("\nAfter modified" +person1.toString());
    }

    public static void registerRoomInformation(){
//        System.out.println("------------------------------------------------------------------------------------------------");
//        System.out.println("Initialized Information");
//        Room room = new SingleRoom("A1",1500);
//        Person person1 = new Student(
//                "John","Boy","Kulai",
//                "011-123456778","999","B2101101B","",true);
//        System.out.println("Registered Information");
//        person1.setRoomNumber("A1");
//        String addResult = room.addPerson(person1);
//        System.out.println("Add Room Result: " + addResult);
//        System.out.println("Person status: " + person1.isLiveHostel() +" In "  +  person1.getRoomNumber());
//        System.out.println("Total Price: " + ((Student)person1).getTotalPrice(14,room));
    }
}
