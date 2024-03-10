package com.student.managment.app.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    public static Connection
    getConnection() {
        String url = "jdbc:mysql://localhost:3306/studentdata";
        String user = "root"; //user of mysql
        String password = "root"; //password of mysql
        Connection conn = null;
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Success!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}

