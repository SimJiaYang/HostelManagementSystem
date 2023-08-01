package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class DeleteRoomController {

    @FXML
    private TextField roomNumber;
    @FXML
    private Label wrongDelete;

    public void deleteRoom(ActionEvent event) throws Exception{
        checkDeleteRoom();
    }

    private void checkDeleteRoom() throws IOException {
        wrongDelete.setTextFill(Color.RED);
        if (roomNumber.getText().toString().equals("")){
            wrongDelete.setText("Please enter room number!");
        }
        else {
            wrongDelete.setText("Successfully delete the room!");
            wrongDelete.setTextFill(Color.GREEN);
        }
    }

    public void clear(ActionEvent event) throws Exception{
        roomNumber.clear();
        wrongDelete.setText("");
    }
}
