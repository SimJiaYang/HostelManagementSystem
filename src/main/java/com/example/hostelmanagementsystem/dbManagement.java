package com.example.hostelmanagementsystem;

import java.sql.*;
import java.util.ArrayList;

import javafx.scene.control.Alert;

public class dbManagement {
    static PreparedStatement preparedStatement;
    static Statement statement;
    static ResultSet result;
    static Connection con;

    public static Hostel oldHostel;
    public static Hostel newHostel;
    public static ArrayList<Person> personList;

    /**
     * Initialized for database connection
     */
    public dbManagement(){
        System.out.println(initializeDB());
        initializedInformation();
    }

    /**
     * Initialized the database connection, it will show
     * the information about the connection status
     * @return The connection status to database
     */
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

    public static void initializedInformation(){
        ArrayList<Room> OldHostelSingleRoom = getRoomList(1,"single");
        ArrayList<Room> OldHostelTripleRoom =  getRoomList(1,"triple");
        ArrayList<Room> NewHostelSingleRoom = getRoomList(2,"single");
        ArrayList<Room> NewHostelTripleRoom = getRoomList(2,"triple");
        int OldHostelCapacitySingleRoom = getCapacitySingle(1);
        int OldHostelCapacityTripleRoom = getCapacityTriple(1);
        int NewHostelCapacitySingleRoom  = getCapacitySingle(2);
        int NewHostelCapacityTripleRoom  = getCapacityTriple(2);
        oldHostel = new OldHostel(
                "1",
                OldHostelCapacitySingleRoom,
                OldHostelCapacityTripleRoom,
                OldHostelSingleRoom,
                OldHostelTripleRoom
        );
        newHostel = new NewHostel(
                "2",
                NewHostelCapacitySingleRoom,
                NewHostelCapacityTripleRoom,
                NewHostelSingleRoom,
                NewHostelTripleRoom
        );
        personList = getPersonList();
    }

    public static ArrayList<Person> getPersonList(){
        ArrayList<Person> persons = new ArrayList<Person>();
        try{
            String sql ="SELECT * FROM person";
            preparedStatement = con.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String id = result.getString("id");
                String email = result.getString("email");
                String gender = result.getString("gender");
                String name = result.getString("name");
                String address = result.getString("address");
                String phone = result.getString("phoneNumber");
                String emergency = result.getString("emergencyContact");
                String roomNumber = result.getString("room_number");
                Person person = new Person(id,name, gender,address, phone,emergency);
                person.setRoom(roomNumber);
                persons.add(person);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return persons;
    }

    public static int getCapacitySingle(int hostelID){
        int capacity = 0;
        try{
            String sql ="SELECT hostel.capacitySingle FROM hostel " +
                    "WHERE hostel.id = ? ";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, hostelID);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                capacity = result.getInt("capacitySingle");
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
//        System.out.println("Single: " + capacity);
        return capacity;
    }

    public static int getCapacityTriple(int hostelID){
        int capacity = 0;
        try{
            String sql ="SELECT hostel.capacityTriple FROM hostel " +
                    "WHERE hostel.id = ? ";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, hostelID);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                capacity = result.getInt("capacityTriple");
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
//        System.out.println("Triple: " + capacity);
        return capacity;
    }

    public static ArrayList<Room> getRoomList(int hostelID, String roomType){
        ArrayList<Room> roomList = new ArrayList<>();
        try{
            String sql ="SELECT room.id FROM room " +
                    "LEFT JOIN roomtype ON room.typeid = roomtype.id " +
                    "WHERE roomtype.hostelID = ? " +
                    "AND roomtype.type = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, hostelID);
            preparedStatement.setString(2, roomType);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String roomID = result.getString("id");
                if (roomType.equals("single")) {
                    roomList.add(new SingleRoom(roomID));
                }else{
                    roomList.add(new TripleRoom(roomID));
                }

            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
//        System.out.println(roomList);
        return roomList;
    }


    /**
     * Show the room id for the hostel (*new hostel or old hostel)
     * @param hostelID - Hostel ID
     * @return Available room for the hostel
     */
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


    /**
     * Show the hostel room only available, which status equal to one
     * @param hostelID - Hostel ID
     * @return Available hostel room
     */
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

    /**
     * Add the room to the hostel
     * @param roomTypeID - The type of the room
     * @param roomID - The ID of the room
     * @return The status for adding the room
     */
    public static String addRoom(int roomTypeID, String roomID) {
        String output = "";
        String id = roomID;

        if(findRoomID(id)){
            showError("Error","The room already exist");
        }
        else{
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

    /**
     * Delete a room from the database
     * @param roomID - The ID of the room
     * @return The status of delete the room
     */
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

    /**
     * Assign the room number to the person
     * @param roomID - Room ID
     * @param personID - Person ID
     * @return The status for adding the person to the room
     */
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

    /**
     * Dalete the person from the room
     * @param personID - Person ID
     * @return The status delete the person from the room
     */
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

    /**
     * Update the room price according the room type
     * @param price - Room price
     * @param roomTypeID - Room type ID
     * @return The status to update the room price
     */
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


    /**
     * Through the room number, get the person who lived inside
     * @param roomID - Room ID
     * @return The person who live in this room
     */
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

    /**
     * Through Person ID, get the room number lived
     * @param personID - Person ID
     * @return The room number for the person lived
     */
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

    /**
     * Through the Person ID, ensure the person has live hostel or not,
     * 0 = no, 1 = yes
     * @param id - Person ID
     * @return Either this person live in hostel or not
     */
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

    /**
     * Find the person id exist or not
     * @param id - Person ID
     * @return Either exist this person or not
     */
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

    /**
     * Find the room id exist or not
     * @param id - Room ID
     * @return Either exist this room or not
     */
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

    /**
     * Get the room type through the room id
     * @param roomID
     * @return The type of the room
     */
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

    /**
     * Get the room capacity through the room ID
     * @param roomID - Room ID
     * @return The capacity of the room
     */
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

    /**
     * Check the room availability through room ID
     * @param roomID - Room ID
     * @return The availability of the room
     */
    public static int getRoomAvailability(String roomID) {
        int roomAvailability = 0;
        roomAvailability = getRoomStorage(roomID)- Integer.parseInt(getNumberPersonLived(roomID));
        return roomAvailability;
    }

    /**
     * Set the status of the room through room ID
     * @param roomID - Room ID
     */
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

    /**
     * Check the room availability through the room ID
     * @param roomID - Room ID
     * @return True if room is available
     */
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

    /**
     * Show the error message
     * @param title - Error message title
     * @param msg - Error message content
     */
    public static void showError(String title, String msg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Show the information
     * @param title - Information title
     * @param msg - Information content
     */
    public void showInfo(String title, String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

