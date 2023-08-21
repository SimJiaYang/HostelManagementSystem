package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.Locale;

public class ViewPersonRoomController {
    @FXML
    private TextField personID;
    @FXML
    private TextField roomNumber;
    @FXML
    private Label wrongView;

    public void viewPersonRoom(ActionEvent event) throws Exception{
        String enteredPersonID = "";
        enteredPersonID = personID.getText().toUpperCase(Locale.ROOT);
        String result = "";

        //Check View Person's Room
        wrongView.setTextFill(Color.RED);
        if (personID.getText().toString().equals("")){
            wrongView.setText("Please enter student/ lecturer id!");
        } else {
            for(int i = 0; i < dbManagement.personList.size(); i++) {
                if(!dbManagement.personList.get(i).getId().equals(enteredPersonID)){
                    result = "This person not found";
                }
                if(dbManagement.personList.get(i).getId().equals(enteredPersonID)){
                    if (dbManagement.personList.get(i).getRoom() != null) {
                        result = dbManagement.personList.get(i).getRoom();
                    } else {
                        result = "This person doesn't live in hostel";
                    }
                    break;
                }
            }
            roomNumber.setText(result);
            wrongView.setTextFill(Color.GREEN);
        }
    }

    public void clear(ActionEvent event) throws Exception{
        personID.clear();
        roomNumber.clear();
        wrongView.setText("");
    }
}
