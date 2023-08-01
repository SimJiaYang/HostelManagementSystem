package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;

import java.io.IOException;

public class AddRoomController {

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
    private TextField roomPrice;
    @FXML
    private Label wrongAddRoom;
    @FXML
    private Button addRoom;
    @FXML
    private Button clear;

    public void addRoom(ActionEvent event) throws Exception{
        checkAddRoom();
    }

    private void checkAddRoom() throws IOException {
        wrongAddRoom.setTextFill(Color.RED);
        if (roomNumber.getText().toString().equals("")){
            wrongAddRoom.setText("Please enter room number!");
        }
        else if (roomPrice.getText().toString().equals("")){
            wrongAddRoom.setText("Please enter room price!");
        }else {
            wrongAddRoom.setText("Successfully add the room!");
            wrongAddRoom.setTextFill(Color.GREEN);
        }

    }

    public void clear(ActionEvent event) throws Exception{
        newHostel.setSelected(true);
        singleRoom.setSelected(true);
        roomNumber.clear();
        roomPrice.clear();
        wrongAddRoom.setText("");
    }


    @FXML
    private void handleOnKeyPressed(KeyEvent event)
    {
        if((!(event.getCode().isDigitKey()) &&
            !((event.getCode()== KeyCode.LEFT)) &&
            !((event.getCode() == KeyCode.RIGHT)) &&
            !((event.getCode() == KeyCode.PERIOD)) &&
            !((event.getCode() == KeyCode.BACK_SPACE)) &&
            !((event.getCode() == KeyCode.ENTER)))) {
            showError("Input Error", "Enter the price only in digit");
        }
    }

    public void showError(String title, String msg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }


}
