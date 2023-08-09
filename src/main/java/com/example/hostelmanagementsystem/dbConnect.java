package com.example.hostelmanagementsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.Alert;

public class dbConnect {
    static PreparedStatement preparedStatement;
    Statement statement;
    static ResultSet result;
    static Connection con;

    public dbConnect(){

    }

    public String initializeDB(){
        String output = "";

        String dbURL = "jdbc:mysql://localhost:3306/oopgroup";
        String username = "root";
        String password = "Kellybe0115";
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
    public static String addUser(Person newPerson){
        String output = "";

        String id = newPerson.getId();
        String roomNumber = newPerson.getRoomNumber();

        try{
            if(findID(id) == true) {
                String sql ="UPDATE person SET roomNumber=? WHERE id=?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, roomNumber);
                preparedStatement.setString(2, id);

                int rows = preparedStatement.executeUpdate();

                if (rows > 0) {
                    output = "A new room has been assigned successfully";
                }
            }
            else showError("Error","The person doesn't exist");
        }catch(SQLException e){
            output = "Fail to add person, Please try again";
        }


        return output;
    }

    //delete room from person
    public static String delete(Person newPerson){
        String output = "";
        String id = newPerson.getId();

        try{
            if(findID(id) == true) {
                String sql ="UPDATE person SET roomNumber=? WHERE id=?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,"-");
                preparedStatement.setString(2,id);

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
    public String addUser(Room newRoom){
        String output = "";
        String id = newRoom.getRoomNumber();
        double price= newRoom.getRoomPrice();
        if(findRoomID(id) == true){
            showError("Error","The room already exist");
        }else{
            try{
                String sql ="INSERT INTO room(id,price) VALUES(?,?)";
                preparedStatement  = con.prepareStatement(sql);
                preparedStatement.setString(1,id);
                preparedStatement.setString(2, String.valueOf(price));
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

    //delete room from person
    public String delete(Room newRoom){
        String output = "";
        String id = newRoom.getRoomNumber();
        try{
            if(findRoomID(id) == true) {
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

