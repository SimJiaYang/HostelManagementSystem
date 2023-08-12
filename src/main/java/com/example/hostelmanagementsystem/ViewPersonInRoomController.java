package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.Locale;

public class ViewPersonInRoomController {

    @FXML
    private ComboBox<String> hostel;
    @FXML
    private TextArea room;
    @FXML
    private TextField roomNumber;
    @FXML
    private TextField personID;
    @FXML
    private Label wrongView;

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

    public void viewPersonInRoom(ActionEvent event) throws Exception{
        String enteredRoomID = "";
        enteredRoomID = roomNumber.getText().toUpperCase(Locale.ROOT);

        //Check View Person In Room
        wrongView.setTextFill(Color.RED);
        if (roomNumber.getText().toString().equals("")){
            wrongView.setText("Please enter room number!");
        } else {
            String result = dbConnect.getRoomLivedByWho(enteredRoomID);
            personID.setText(result);
            wrongView.setTextFill(Color.GREEN);
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n" + dbConnect.showHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbConnect.showHostel(2));
        }
    }

    public void clear(ActionEvent event) throws Exception{
        roomNumber.clear();
        personID.clear();
        wrongView.setText("");
    }
}
