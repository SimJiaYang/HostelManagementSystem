package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;

public class LogoutController {

    public void userLogOut(ActionEvent event) throws Exception{
        HostelManagementSystem m = new HostelManagementSystem();
        m.changeScene("login.fxml");
    }
}