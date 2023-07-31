package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class AddPersonToRoomController {

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

    public void addPersonToRoom(ActionEvent event) throws Exception{
        checkAddPersonToRoom();
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
