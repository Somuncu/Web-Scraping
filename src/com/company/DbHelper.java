package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String userName="root";
    private String password="5078";
    private String dbUrl = "jdbc:mysql://localhost:3306/koton";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,userName,password);
    }

    public void showErrorMessage(SQLException exeption){
        System.out.println("Error:" + exeption.getMessage());
    }
}
