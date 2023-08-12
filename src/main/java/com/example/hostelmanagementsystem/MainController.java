package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController {

    @FXML
    private Pane contentPane;

    public void initialize() {
        loadPage("welcome.fxml");
    }

    @FXML
    private void loadAddRoom(ActionEvent event) {
        loadPage("addRoom.fxml");
    }

    @FXML
    private void loadDeleteRoom(ActionEvent event) {
        loadPage("deleteRoom.fxml");
    }

    @FXML
    private void loadAddPersonToRoom(ActionEvent event) {
        loadPage("addPersonToRoom.fxml");
    }

    @FXML
    private void loadDeletePersonFromRoom(ActionEvent event) {
        loadPage("deletePersonFromRoom.fxml");
    }

    @FXML
    private void loadUpdatePrice(ActionEvent event) {
        loadPage("updatePrice.fxml");
    }

    @FXML
    private void loadViewPersonInRoom(ActionEvent event) {
        loadPage("viewPersonInRoom.fxml");
    }

    @FXML
    private void loadViewPersonRoom(ActionEvent event) {
        loadPage("viewPersonRoom.fxml");
    }

    @FXML
    private void loadLogOut(ActionEvent event) {
        loadPage("logout.fxml");
    }

    private void loadPage(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent page = loader.load();
            contentPane.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}