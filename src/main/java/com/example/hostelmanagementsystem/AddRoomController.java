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
        room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbConnect.showHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbConnect.showHostel(2));
    }

    public void displayRoom(){
        if(hostel.getValue().equals("Old Hostel")){
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbConnect.showHostel(1));
        } else if (hostel.getValue().equals("New Hostel")){
            room.setText("------------------------------------------New Hostel Room-----------------------------------------\n" + dbConnect.showHostel(2));
        } else if (hostel.getValue().equals("All Hostels")){
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbConnect.showHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbConnect.showHostel(2));
        }
    }

    public void addRoom(ActionEvent event) throws Exception{
        int selectedRoomTypeID = 0; 
        String enteredRoomID = "";

        if(oldHostel.isSelected()){
            if(singleRoom.isSelected()) {
                selectedRoomTypeID = 1;
            } else if (tripleRoom.isSelected()) {
                selectedRoomTypeID = 3;
            }
        }else if(newHostel.isSelected()){
            if(singleRoom.isSelected()) {
                selectedRoomTypeID = 2;
            } else if (tripleRoom.isSelected()) {
                selectedRoomTypeID = 4;
            }
        }
        enteredRoomID = roomNumber.getText().toUpperCase(Locale.ROOT);

        //Check Add Room
        wrongAddRoom.setTextFill(Color.RED);
        if (roomNumber.getText().toString().equals("")){
            wrongAddRoom.setText("Please enter room number!");
        } else {
            String result = dbConnect.addRoom(selectedRoomTypeID, enteredRoomID);
            wrongAddRoom.setText(result);
            wrongAddRoom.setTextFill(Color.GREEN);
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbConnect.showHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbConnect.showHostel(2));
        }

    }

    public void clear(ActionEvent event) throws Exception{
        newHostel.setSelected(true);
        singleRoom.setSelected(true);
        roomNumber.clear();
        wrongAddRoom.setText("");
    }

}
