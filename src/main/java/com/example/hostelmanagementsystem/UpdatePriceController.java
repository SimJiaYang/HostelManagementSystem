package com.example.hostelmanagementsystem;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class UpdatePriceController {

    @FXML
    private RadioButton newHostel;
    @FXML
    private RadioButton oldHostel;
    @FXML
    private RadioButton singleRoom;
    @FXML
    private RadioButton tripleRoom;
    @FXML
    private TextField roomPrice;
    @FXML
    private Label wrongUpdatePrice;

    public void updatePrice(ActionEvent event) throws Exception{
        int selectedRoomTypeID = 0;
        double enteredRoomPrice = 0.0;

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
        enteredRoomPrice = Integer.parseInt(roomPrice.getText());

        String result = dbConnect.updateRoomPrice(enteredRoomPrice, selectedRoomTypeID);

        wrongUpdatePrice.setTextFill(Color.RED);
        if (roomPrice.getText().toString().equals("")){
            wrongUpdatePrice.setText("Please enter room price!");
        }else {
            wrongUpdatePrice.setText(result);
            wrongUpdatePrice.setTextFill(Color.GREEN);
        }
    }

    public void clear(ActionEvent event) throws Exception{
        roomPrice.clear();
        wrongUpdatePrice.setText("");
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
