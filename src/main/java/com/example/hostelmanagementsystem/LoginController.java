package com.example.hostelmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogIn(ActionEvent event) throws Exception{
        checkLogin();
    }

    private void checkLogin() throws IOException {
        HostelManagementSystem m = new HostelManagementSystem();
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("1234")){
            wrongLogIn.setText("Success!");
            m.changeScene("main.fxml");
        }
        else if (username.getText().isEmpty() && password.getText().isEmpty()){
            wrongLogIn.setText("Please enter your data!");
        }
        else{
            wrongLogIn.setText("Wrong username or password!");
        }

    }
}
