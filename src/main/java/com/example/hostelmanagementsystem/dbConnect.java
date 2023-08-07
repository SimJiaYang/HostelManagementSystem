package com.example.hostelmanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.Alert;

public class dbConnect {
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet result;
    Connection con;

    public dbConnect(){

    }

    public String initializeDB(){
        String output = "";

        String dbURL = "jdbc:mysql://localhost:3306/oop_group";
        String username = "root";
        String password = "1017";
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            if (con != null) {
                output = "Database --> connected";
            }
        }catch (SQLException ex){
            output = "Database --> not connected";
        }
        return output;
    }

}

