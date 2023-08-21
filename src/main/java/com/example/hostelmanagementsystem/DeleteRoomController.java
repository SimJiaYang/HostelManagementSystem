package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.Locale;

public class DeleteRoomController {

    @FXML
    private ComboBox<String> hostel;
    @FXML
    private TextArea room;
    @FXML
    private TextField roomNumber;
    @FXML
    private Label wrongDelete;

    public void initialize() {
        hostel.getItems().addAll("Old Hostel", "New Hostel", "All Hostels");
        room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n"
                + dbManagement.showHostel(1) + "\n\n------------------------------------------New Hostel Room-----------------------------------------\n" + dbManagement.showHostel(2));
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
                    "\n------------------------------------------New Hostel Room-----------------------------------------\n"
                    + dbManagement.newHostel.toString());
        }
    }

    public void deleteRoom(ActionEvent event) throws Exception{
        String enteredRoomID = "";
        enteredRoomID = roomNumber.getText().toUpperCase(Locale.ROOT);
        String result = "";

        //Check Delete Room
        wrongDelete.setTextFill(Color.RED);
        if (roomNumber.getText().toString().equals("")){
            wrongDelete.setText("Please enter room number!");
        }
        else {
            boolean isSuccess = false;
            for(int i = 0; i < dbManagement.personList.size(); i++) {
                if(dbManagement.personList.get(i).getRoom()==null){
                    // Continue cannot delete
                    continue;
                }
                else if(dbManagement.personList.get(i).getRoom().equals(enteredRoomID)){
                    isSuccess = true;
                    result = "This room has been lived by " +
                            dbManagement.personList.get(i).getName();
                    break;
                }
            }
            if(!isSuccess) {
                if (dbManagement.newHostel.removeSingleRoom(enteredRoomID) ||
                        dbManagement.newHostel.removeTripleRoom(enteredRoomID) ||
                        dbManagement.oldHostel.removeSingleRoom(enteredRoomID) ||
                        dbManagement.oldHostel.removeTripleRoom(enteredRoomID)) {
                    result = dbManagement.deleteRoom(enteredRoomID);
                } else {
                    result = "Some error occur";
                }
            }

            wrongDelete.setText(result);
            wrongDelete.setTextFill(Color.GREEN);
            room.setText("-------------------------------------------Old Hostel Room-----------------------------------------\n"
                    + dbManagement.oldHostel.toString()  +
                    "\n------------------------------------------New Hostel Room-----------------------------------------\n"
                    + dbManagement.newHostel.toString());
        }
    }

    public void clear(ActionEvent event) throws Exception{
        roomNumber.clear();
        wrongDelete.setText("");
    }
}
