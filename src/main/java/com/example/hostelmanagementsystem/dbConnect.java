package com.example.hostelmanagementsystem;

import java.sql.*;

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
        String password = "2002";
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
                output += "|"+ roomID + "|  ";
            }
        }catch(SQLException e){
            output = "Fail to find the hostel";
        }
        return output;
    }

    public static String showAvailableHostel(int hostelID){
        String output = "";
        try{
            String sql ="SELECT room.id FROM room LEFT JOIN roomtype ON room.typeid = roomtype.id WHERE roomtype.hostelID = ? AND room.status = 1";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, hostelID);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                String roomID = result.getString("id");
                output += "|"+ roomID + "|  ";
            }
        }catch(SQLException e){
            output = "Fail to find the hostel";
        }
        return output;
    }

    public static String addRoom(int roomTypeID, String roomID) {
        String output = "";
        String id = roomID;

        if(findRoomID(id)){
            showError("Error","The room already exist");
        }else{
            try {
                String insertSQL = "INSERT INTO room (id, typeid, status) VALUES (?, ?, ?)";
                preparedStatement = con.prepareStatement(insertSQL);
                preparedStatement.setString(1, roomID);
                preparedStatement.setInt(2, roomTypeID);
                preparedStatement.setInt(3, 1);

                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    output = "Room added successfully";
                } else {
                    output = "Failed to add room";
                }
            } catch (SQLException e) {
                output = "Failed to add room, \nPlease try again";
            }
        }
        return output;
    }

    public static String deleteRoom(String roomID){
        String output = "";
        int numberPersonLived = 0;
        String id = roomID;

        numberPersonLived = Integer.parseInt(getNumberPersonLived(id));

        if(!findRoomID(id)){
            showError("Error","The room doesn't exist");
        }else if (numberPersonLived > 0) {
            showError("Error", "There is person lived in the room, the room cannot be deleted");
        }else{
            try{
                String sql ="DELETE FROM room WHERE id=?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,roomID);
                int rows = preparedStatement.executeUpdate();
                if(rows>0){
                    output = "The room has been removed";
                }else {
                    output = "Failed to delete the room";
                }
                // con.close();
            }catch(SQLException e){
                output = "Fail to delete the room, \nPlease try again";
            }
        }
        return output;
    }

    public static String addPersonToRoom(String roomID,String personID){
        String output = "";

        try{
            if(findID(personID) && findRoomID(roomID) && checkRoomAvailability(roomID) && !isLiveHostel(personID)) {
                String sql ="UPDATE person SET room_number=?,isLiveHostel=? WHERE id=?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, roomID);
                preparedStatement.setString(2, "1");
                preparedStatement.setString(3, personID);

                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    output = "A new room has been assigned successfully";
                    setRoomStatus(roomID);
                }else{
                    output = "Failed to add person to room";
                }
            } else if(!findID(personID)){
                showError("Error","This person doesn't exist");
            }else if(isLiveHostel(personID)){
                showError("Error","This person already live in the hostel");
            }else if(!findRoomID(roomID)){
                showError("Error","The room doesn't exist");
            }else if(!checkRoomAvailability(roomID)){
                showError("Error","The room is full!");
            }

        }catch(SQLException e){
            output = "Fail to add person to room, Please try again";
        }
        return output;
    }

    //haven't done yet
    //delete room from person
    public static String deletePersonFromRoom(String personID){
        String output = "";
        String roomID = "";

        try{
            if(findID(personID) && isLiveHostel(personID)){
                roomID = getPersonRoomNumber(personID);
                String sql ="UPDATE person SET room_number=?,isLiveHostel=? WHERE id=?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,null);
                preparedStatement.setString(2,"0");
                preparedStatement.setString(3,personID);

                int rows = preparedStatement.executeUpdate();
                if(rows>0){
                    output = "The room has been removed from the person";
                    setRoomStatus(roomID);
                }
            }else if(!findID(personID)){
                showError("Error","The person not found");
            }else if(!isLiveHostel(personID)){
                showError("Error","This person doesn't live in hostel!");
            }

            // con.close();
        }catch(SQLException e){
            output = "Fail to delete the room from person, \nPlease try again";
        }
        return output;
    }

    public static String updateRoomPrice(double price, int roomTypeID){
        String output = "";
        String id = String.valueOf(roomTypeID);
        try{
            String sql ="UPDATE roomtype SET price=? WHERE id=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, price);
            preparedStatement.setString(2,id);

            int rows = preparedStatement.executeUpdate();
            if(rows>0){
                output = "The room price has been updated";
            }
        }catch(SQLException e){
            output = "Fail to update the room price, \nPlease try again";
        }
        return output;
    }

    /*
    public static List<String> getRoomPrice() {
        List<String> roomPrice = new ArrayList<>();
        try {
            String sql ="SELECT price FROM roomtype";
            preparedStatement = con.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                String item = result.getString("price");
                roomPrice.add("RM " + item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomPrice;
    }
    */

    public static String getRoomLivedByWho(String roomID){
        String output = "";
        int count = 0;

        if(!findRoomID(roomID)){
            showError("Error","The room doesn't exist");
        }else{
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
                    String roomType = result.getString("type");
                    output += "|"+personID + "|  ";
                    count++;
                }
                if (count == 0) {
                    output = "No person lives in the room";
                }
            }catch(SQLException e){
                output = "Failed to find the person in the room";
            }
        }
        return output;
    }

    public static String getPersonRoom(String personID) {
        String output = "";

        if(!findID(personID)){
            showError("Error","This person doesn't exist");
        }else {
            try {
                String sql = "SELECT room_number FROM person WHERE id=?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, personID);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    output = resultSet.getString("room_number");
                    if (output == null) {
                        output = "This person doesn't live in hostel";
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return output;
    }

    public static String getNumberPersonLived(String roomID){
        String output = "";
        int count = 0;
        try{
            String sql ="SELECT person.id FROM person " +
                    "WHERE person.room_number=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, roomID);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String personID = result.getString("id");
                count++;
            }
            output = String.valueOf(count);
        }catch(SQLException e){
            output = "Failed to find the number of person in the room";
        }
        return output;
    }

    public static String getPersonRoomNumber(String personID) {
        String roomNumber = null;
        try {
            String sql = "SELECT room_number FROM person WHERE id=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, personID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                roomNumber = resultSet.getString("room_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomNumber;
    }

    public static boolean isLiveHostel(String id) {
        boolean isLiveHostel = false;
        try {
            String sql = "SELECT isLiveHostel FROM person WHERE id=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, id);
            result = preparedStatement.executeQuery();

            if (result.next()) {
                int isLiveHostelValue = Integer.parseInt(result.getString("isLiveHostel"));
                isLiveHostel = (isLiveHostelValue == 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isLiveHostel;
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
    public static boolean findRoomID(String id){
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

    public static int getRoomTypeId(String roomID) {
        int roomTypeId = -1;

        try {
            String sql = "SELECT typeid FROM room WHERE id=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, roomID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                roomTypeId = resultSet.getInt("typeid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomTypeId;
    }

    public static int getRoomStorage(String roomID) {
        int roomType;
        int roomStorage = 0;

        roomType = getRoomTypeId(roomID);
        if(roomType == 1 || roomType == 2){
            roomStorage = 1;
        } else if (roomType == 3 || roomType ==4) {
            roomStorage = 3;
        }
        return roomStorage;
    }

    public static int getRoomAvailability(String roomID) {
        int roomAvailability = 0;
        roomAvailability = getRoomStorage(roomID)- Integer.parseInt(getNumberPersonLived(roomID));
        return roomAvailability;
    }

    public static void setRoomStatus(String roomID) {
        int status = 1;

        if (getRoomAvailability(roomID) <= 0) {
            status = 0;
        }else if(getRoomAvailability(roomID) > 0){
            status = 1;
        }
        try {
            String sql = "UPDATE room SET status=? WHERE id=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, status);
            preparedStatement.setString(2, roomID);

            // Execute the update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkRoomAvailability(String roomID) {
        boolean isAvailable = false;
        try {
            String sql = "SELECT * FROM room WHERE id=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, roomID);
            result = preparedStatement.executeQuery();

            if (result.next()) {
                int status = result.getInt("status");
                isAvailable = (status == 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAvailable;
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

