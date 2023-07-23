package com.example.hostelmanagementsystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HostelManagementSystem extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane bp= new BorderPane();
        Label title = new Label("Hello World");
        bp.setCenter(title);
        Scene scene = new Scene(bp, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println(new Person());
        System.out.println(new Lecturer());
        System.out.println(new Student());
        launch();
    }
}