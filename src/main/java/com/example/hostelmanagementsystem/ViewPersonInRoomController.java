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

    public void viewPersonInRoom(ActionEvent event) throws Exception{
        String enteredRoomID = "";
        enteredRoomID = roomNumber.getText().toUpperCase(Locale.ROOT);
        String result = "";

        //Check View Person In Room
        wrongView.setTextFill(Color.RED);
        if (roomNumber.getText().toString().equals("")){
            wrongView.setText("Please enter room number!");
        } else {
            boolean isSuccess = false;
            for(int i = 0; i < dbManagement.personList.size(); i++) {
                if(dbManagement.personList.get(i).getRoom()==null){
                    // Continue cannot delete
                    continue;
                }
                else if(dbManagement.personList.get(i).getRoom().equals(enteredRoomID)){
                    isSuccess = true;
                    result = dbManagement.personList.get(i).getId();
                    break;
                }else{
                    result = "Failed to find the person in the room";
                }
            }

            personID.setText(result);
            wrongView.setTextFill(Color.GREEN);
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n"
                    + dbManagement.oldHostel.toString()  +
                    "\n------------------------------------------New Hostel Room-----------------------------------------\n"
                    + dbManagement.newHostel.toString());
        }
    }

    public void clear(ActionEvent event) throws Exception{
        roomNumber.clear();
        personID.clear();
        wrongView.setText("");
    }
}
