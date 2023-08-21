package com.example.hostelmanagementsystem;

public class TestingHostelManagementSystem {
    public static void main(String[] args){
        dbManagement dbConnect = new dbManagement();
        System.out.println(dbConnect.initializeDB());
        System.out.println("\nOld Hostel");
        System.out.println( dbConnect.showHostel(1));
        System.out.println("\nNew Hostel");
        System.out.println( dbConnect.showHostel(2));
        System.out.println("\nGET ROOM NS1");
        System.out.println(dbConnect.getRoomLivedByWho("NS1"));
        System.out.println("\nGetNumberPersonLived for NS1");
        System.out.println(dbConnect.getNumberPersonLived("NS1"));
        System.out.println("Add room");
        System.out.println("Delete Room");
        System.out.println("Add user to room");
        System.out.println("Delete user from room");

        System.out.println("hello world");


//        newHostel();
//        oldHostel();
//        registerPerson();
//        registerRoomInformation();
    }
}
