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
        room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbConnect.showAvailableHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbConnect.showAvailableHostel(2));
    }

    public void displayRoom(){
        if(hostel.getValue().equals("Old Hostel")){
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbConnect.showAvailableHostel(1));
        } else if (hostel.getValue().equals("New Hostel")){
            room.setText("------------------------------------------New Hostel Room-----------------------------------------\n" + dbConnect.showAvailableHostel(2));
        } else if (hostel.getValue().equals("All Hostels")){
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbConnect.showAvailableHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbConnect.showAvailableHostel(2));
        }
    }

    public void addPersonToRoom(ActionEvent event) throws Exception{
        String enteredRoomID = "";
        String enteredPersonID = "";

        enteredRoomID = roomNumber.getText().toUpperCase();
        enteredPersonID = personID.getText().toUpperCase();

        wrongAddPersonToRoom.setTextFill(Color.RED);
        if (roomNumber.getText().toString().equals("")){
            wrongAddPersonToRoom.setText("Please enter room number!");
        }
        else if (personID.getText().toString().equals("")){
            wrongAddPersonToRoom.setText("Please enter student / lecturer id!");
        }else {
            String result = dbConnect.addPersonToRoom(enteredRoomID,enteredPersonID);
            wrongAddPersonToRoom.setText(result);
            wrongAddPersonToRoom.setTextFill(Color.GREEN);
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbConnect.showAvailableHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbConnect.showAvailableHostel(2));
        }
    }

    private void checkAddPersonToRoom() throws IOException {
        wrongAddPersonToRoom.setTextFill(Color.RED);
        if (roomNumber.getText().toString().equals("")){
            wrongAddPersonToRoom.setText("Please enter room number!");
        }
        else if (personID.getText().toString().equals("")){
            wrongAddPersonToRoom.setText("Please enter student / lecturer id!");
        }else {
            wrongAddPersonToRoom.setText("Successfully add the student / lecturer to room!");
            wrongAddPersonToRoom.setTextFill(Color.GREEN);
        }

    }
    public void clear(ActionEvent event) throws Exception{
        roomNumber.clear();
        personID.clear();
        wrongAddPersonToRoom.setText("");
    }
}
