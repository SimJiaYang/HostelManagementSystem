package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class DeletePersonFromRoomController {

    @FXML
    private TextField personID;
    @FXML
    private Label wrongDeletePersonFromRoom;

    public void deletePersonFromRoom(ActionEvent event) throws Exception{
        checkDeletePersonFromRoom();
        String id = personID.getText();
        Person p1 = new Person(id,id,id,id,id,id,id);
        dbConnect.delete(p1);;
    }

    private void checkDeletePersonFromRoom() throws IOException {
        wrongDeletePersonFromRoom.setTextFill(Color.RED);
        if (personID.getText().toString().equals("")){
            wrongDeletePersonFromRoom.setText("Please enter student / lecturer id!");
        }
        else {
            wrongDeletePersonFromRoom.setText("Successfully delete the student / lecturer from room!");
            wrongDeletePersonFromRoom.setTextFill(Color.GREEN);
        }
    }

    public void clear(ActionEvent event) throws Exception{
        personID.clear();
        wrongDeletePersonFromRoom.setText("");
    }
}
