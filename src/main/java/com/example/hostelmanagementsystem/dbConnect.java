package com.example.hostelmanagementsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.Alert;

public class dbConnect {
    static PreparedStatement preparedStatement;
    static Statement statement;
    static ResultSet result;
    static Connection con;

    public dbConnect(){

    }

    public String initializeDB(){
        String output = "";

        String dbURL = "jdbc:mysql://localhost:3306/oop_group";
        String username = "root";
        String password = "1017";
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            if (con != null) {
                output = "Database --> connected";
            }
        }catch (SQLException ex){
            output = "Database --> not connected";
        }
        return output;
    }

    public static String showHostel(int hostelID){
        String output = "";
        try{
                String sql ="SELECT room.id FROM room LEFT JOIN roomtype ON room.typeid = roomtype.id WHERE roomtype.hostelID = ?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, hostelID);

                result = preparedStatement.executeQuery();
            while (result.next()) {
                String roomID = result.getString("id");
                output += roomID + " ";
            }
        }catch(SQLException e){
            output = "Fail to find the hostel";
        }
        return output;
    }

    public static void getRoom(String roomID){
        String output = "";
        int count = 0;
        try{
            String sql ="SELECT person.id, roomtype.type FROM person " +
                    "LEFT JOIN room ON person.room_number = room.id " +
                    "LEFT JOIN roomtype ON room.typeid = roomtype.id " +
                    "WHERE person.room_number=? ";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, roomID);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String personID = result.getString("id");
                output += personID + " ";
                count++;
            }
        }catch(SQLException e){
            output = "Fail to add person to room, Please try again";
        }
    }



    // set person rooms
    public static String addUser(String roomNumber,String personID){
        String output = "";
        String id = personID;

        try{
            if(findID(id)) {
                String sql ="UPDATE person SET room_number=?,isLiveHostel=? WHERE id=?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, roomNumber);
                preparedStatement.setString(2, "1");
                preparedStatement.setString(3, id);

                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    output = "A new room has been assigned successfully";
                }
            }
            else showError("Error","The person doesn't exist");
        }catch(SQLException e){
            output = "Fail to add person to room, Please try again";
        }
        return output;
    }

    //delete room from person
    public static String delete(String personID){
        String output = "";
        String id = personID;

        try{
            if(findID(id)) {
                String sql ="UPDATE person SET room_number=?,isLiveHostel=? WHERE id=?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,null);
                preparedStatement.setString(2,"0");
                preparedStatement.setString(3,id);

                int rows = preparedStatement.executeUpdate();
                if(rows>0){
                    output = "The room has been removed from the person";
                }}
            else{
                showError("Error","The person not found");

            }
            // con.close();
        }catch(SQLException e){
            output = "Fail to delete the room from person, \nPlease try again";
        }
        return output;
    }

    //add new room
    public String addRoom(String roomID, String roomType){
        String output = "";
        String id = roomID;

        if(findRoomID(id)){
            showError("Error","The room already exist");
        }else{
            try{
                String sql ="INSERT INTO room(id,typeID) VALUES(?,?)";
                preparedStatement  = con.prepareStatement(sql);
                preparedStatement.setString(1,id);
                preparedStatement.setString(2,roomType);
                int rows = preparedStatement.executeUpdate();

                if(rows>0){
                    output = "A new room has been inserted successfully";
                }
            }catch(SQLException e){
                output = "Fail to add the room, Please try again";
            }
        }
        return output;
    }

    //delete room
    public String deleteRoom(String roomID){
        String output = "";
        String id = roomID;
        try{
            if(findRoomID(id)) {
                String sql ="DELETE FROM room WHERE id=?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,id);

                int rows = preparedStatement.executeUpdate();
                if(rows>0){
                    output = "The room has been removed";
                }}
            else{
                showError("Error","The room not found");

            }
            // con.close();
        }catch(SQLException e){
            output = "Fail to delete the room, \nPlease try again";
        }
        return output;
    }

    //search person data
    public static boolean findID(String id){
        boolean gotIt= false;
        try{
            String searchSQL ="SELECT * FROM person WHERE id=?";
            preparedStatement = con.prepareStatement(searchSQL);
            preparedStatement.setString(1,id);
            result = preparedStatement.executeQuery();
            gotIt = result.next();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return gotIt;
    }

    //search room data
    public boolean findRoomID(String id){
        boolean gotIt= false;
        try{
            String searchSQL ="SELECT * FROM room WHERE id=?";
            preparedStatement = con.prepareStatement(searchSQL);
            preparedStatement.setString(1,id);
            result = preparedStatement.executeQuery();
            gotIt = result.next();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return gotIt;
    }

    //--------Display error message------------//
    public static void showError(String title, String msg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    //--------Display Message------------//
    public void showInfo(String title, String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

