package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.*;

import java.util.Locale;

public class AddRoomController {

    @FXML
    private ComboBox<String> hostel;
    @FXML
    private TextArea room;
    @FXML
    private RadioButton newHostel;
    @FXML
    private RadioButton oldHostel;
    @FXML
    private RadioButton singleRoom;
    @FXML
    private RadioButton tripleRoom;
    @FXML
    private TextField roomNumber;
    @FXML
    private Label wrongAddRoom;

    public void initialize() {
        hostel.getItems().addAll("Old Hostel", "New Hostel", "All Hostels");
        room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n"
                + dbManagement.oldHostel.toString()  +
                "\n\n------------------------------------------New Hostel Room-----------------------------------------\n"
                + dbManagement.newHostel.toString());
    }

    public void displayRoom(){
        if(hostel.getValue().equals("Old Hostel")){
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n"
                    + dbManagement.oldHostel.toString());
        } else if (hostel.getValue().equals("New Hostel")){
            room.setText("------------------------------------------New Hostel Room-----------------------------------------\n"
                    + dbManagement.newHostel.toString());
        } else if (hostel.getValue().equals("All Hostels")){
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n"
                    + dbManagement.oldHostel.toString()  +
                    "\n\n------------------------------------------New Hostel Room-----------------------------------------\n"
                    + dbManagement.newHostel.toString());
        }
    }

    public void addRoom(ActionEvent event) throws Exception{
        int selectedRoomTypeID = 0; 
        String enteredRoomID = "";
        boolean isSuccessful = true;

        enteredRoomID = roomNumber.getText().toUpperCase(Locale.ROOT);

        //Check Add Room
        wrongAddRoom.setTextFill(Color.RED);
        if (roomNumber.getText().toString().equals("")){
            wrongAddRoom.setText("Please enter room number!");
        } else {
            if(oldHostel.isSelected()){
                if(singleRoom.isSelected()) {
                    selectedRoomTypeID = 1;
                    isSuccessful = dbManagement.oldHostel.addSingleRoom(new SingleRoom(roomNumber.getText().toUpperCase()));
                } else if (tripleRoom.isSelected()) {
                    selectedRoomTypeID = 3;
                    isSuccessful = dbManagement.oldHostel.addTripleRoom(new TripleRoom(roomNumber.getText().toUpperCase()));
                }
            }else if(newHostel.isSelected()){
                if(singleRoom.isSelected()) {
                    selectedRoomTypeID = 2;
                    isSuccessful = dbManagement.newHostel.addSingleRoom(new SingleRoom(roomNumber.getText().toUpperCase()));
                } else if (tripleRoom.isSelected()) {
                    selectedRoomTypeID = 4;
                    isSuccessful = dbManagement.newHostel.addTripleRoom(new TripleRoom(roomNumber.getText().toUpperCase()));
                }
            }

            String result = "";
            if(isSuccessful){
                result = dbManagement.addRoom(selectedRoomTypeID, enteredRoomID);
            }else{
                result = "Some error occur";
            }

            wrongAddRoom.setText(result);
            wrongAddRoom.setTextFill(Color.GREEN);
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n"
                    + dbManagement.oldHostel.toString()  +
                    "\n------------------------------------------New Hostel Room-----------------------------------------\n"
                    + dbManagement.newHostel.toString());
        }

    }

    public void clear(ActionEvent event) throws Exception{
        newHostel.setSelected(true);
        singleRoom.setSelected(true);
        roomNumber.clear();
        wrongAddRoom.setText("");
    }

}
