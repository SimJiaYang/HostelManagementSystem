package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class DeletePersonFromRoomController {

    @FXML
    private ComboBox<String> hostel;
    @FXML
    private TextArea room;
    @FXML
    private TextField personID;
    @FXML
    private Label wrongDeletePersonFromRoom;

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

    public void deletePersonFromRoom(ActionEvent event) throws Exception{
        String id = personID.getText();

        wrongDeletePersonFromRoom.setTextFill(Color.RED);
        if (personID.getText().toString().equals("")){
            wrongDeletePersonFromRoom.setText("Please enter student / lecturer id!");
        }
        else {
            String result = dbManagement.deletePersonFromRoom(id);
            wrongDeletePersonFromRoom.setText(result);
            wrongDeletePersonFromRoom.setTextFill(Color.GREEN);
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbManagement.showAvailableHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbManagement.showAvailableHostel(2));
        }
    }

    public void clear(ActionEvent event) throws Exception{
        personID.clear();
        wrongDeletePersonFromRoom.setText("");
    }
}
