package com.example.hostelmanagementsystem;

import java.util.ArrayList;

public class TestingHostelManagementSystem {
    public static void main(String[] args){
        newHostel();
        oldHostel();
    }
    public static void newHostel(){
        System.out.println("------------------------------------------------------------------------------------------------");
        // For new hostel
        ArrayList<Room> singleRooms = new ArrayList<Room>();
        ArrayList<Room> tripleRooms = new ArrayList<Room>();
        double singleRoomPrice = 800;
        double tripleRoomPrice = 500;
        for(int i=0;i<15;i++){
            singleRooms.add(new SingleRoom("A" + (i+1),singleRoomPrice));
        }
        for(int i=0;i<15;i++){
            tripleRooms.add(new TripleRoom("B" + (i+1),tripleRoomPrice));
        }
        int singleRoomSize = singleRooms.size();
        int tripleRoomSize = tripleRooms.size();
        Hostel hostel = new NewHostel(singleRoomSize,tripleRoomSize,singleRooms,tripleRooms);
        System.out.println("Before remove" + hostel.toString());

        // Remove room
        Room room = singleRooms.get(0);
        Room addRoom = new SingleRoom("Store Room",0);
        hostel.removeSingleRoom(room);
        hostel.addSingleRoom(addRoom);

        //System.out.println(isSuccess);
        System.out.println("\nAfter remove and Add" +hostel.toString());

        //Get arraylist of single room and double room
        System.out.println("Get arraylist of single room and double room");
        System.out.println(hostel.getSingleRoom().toString());
        System.out.println(hostel.getTripleRoom().toString());
    }

    public static void oldHostel(){
        System.out.println("------------------------------------------------------------------------------------------------");
        // For new hostel
        ArrayList<Room> singleRooms = new ArrayList<Room>();
        ArrayList<Room> tripleRooms = new ArrayList<Room>();
        double singleRoomPrice = 400;
        double tripleRoomPrice = 300;
        for(int i=0;i<20;i++){
            singleRooms.add(new SingleRoom("C" + (i+1),singleRoomPrice));
        }
        for(int i=0;i<20;i++){
            tripleRooms.add(new TripleRoom("D" + (i+1),tripleRoomPrice));
        }
        int singleRoomSize = singleRooms.size();
        int tripleRoomSize = tripleRooms.size();

        Hostel hostel = new OldHostel(singleRoomSize,tripleRoomSize,singleRooms,tripleRooms);
        System.out.println("\nBefore remove" + hostel.toString());
        // Remove room
        Room room = tripleRooms.get(14);
        Room addRoom = new TripleRoom("Study Room",0);
        hostel.removeTripleRoom(room);
        hostel.addTripleRoom(addRoom);
//        System.out.println(isSuccess);
        System.out.println("\nAfter remove and Add" +hostel.toString());
    }
}
