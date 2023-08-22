package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class AddPersonToRoomController {

    @FXML
    private ComboBox<String> hostel;
    @FXML
    private TextArea room;
    @FXML
    private TextField roomNumber;
    @FXML
    private TextField personID;
    @FXML
    private Label wrongAddPersonToRoom;
    @FXML
    private Button addPersonToRoom;
    @FXML
    private Button clear;

    public void initialize() {
        hostel.getItems().addAll("Old Hostel", "New Hostel", "All Hostels");
        room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbManagement.showAvailableHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbManagement.showAvailableHostel(2));
    }

    public void displayRoom(){
        if(hostel.getValue().equals("Old Hostel")){
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbManagement.showAvailableHostel(1));
        } else if (hostel.getValue().equals("New Hostel")){
            room.setText("------------------------------------------New Hostel Room-----------------------------------------\n" + dbManagement.showAvailableHostel(2));
        } else if (hostel.getValue().equals("All Hostels")){
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbManagement.showAvailableHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbManagement.showAvailableHostel(2));
        }
    }


    public void addPersonToRoom(ActionEvent event) throws Exception {
        String enteredRoomID = "";
        String enteredPersonID = "";
        String result = "";

        enteredRoomID = roomNumber.getText().toUpperCase();
        enteredPersonID = personID.getText().toUpperCase();

        wrongAddPersonToRoom.setTextFill(Color.RED);

        if (roomNumber.getText().toString().equals("")) {
            wrongAddPersonToRoom.setText("Please enter room number!");
        } else if (personID.getText().toString().equals("")) {
            wrongAddPersonToRoom.setText("Please enter student / lecturer id!");
        } else {
            result = dbManagement.addPersonToRoom(enteredRoomID, enteredPersonID);
            if (result.equals("A new room has been assigned successfully")) {
                for (int i = 0; i < dbManagement.personList.size(); i++) {
                    if (dbManagement.personList.get(i).getId().equals(enteredPersonID)) {
                        dbManagement.personList.get(i).setRoom(enteredRoomID);
                    }
                }
            }
                wrongAddPersonToRoom.setText(result);
                wrongAddPersonToRoom.setTextFill(Color.GREEN);
                room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" +
                        dbManagement.showAvailableHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbManagement.showAvailableHostel(2));

        }
    }

    public void clear(ActionEvent event) throws Exception{
        roomNumber.clear();
        personID.clear();
        wrongAddPersonToRoom.setText("");
    }
}
