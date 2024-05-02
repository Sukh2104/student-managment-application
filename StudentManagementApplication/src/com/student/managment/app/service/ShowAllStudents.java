package com.student.managment.app.service;

import com.student.managment.app.config.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowAllStudents implements ShowAllStudentRecords {
    @Override
    public void showAllStudentRecords() {

        {
        // TODO Auto-generated method stub
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "select * from student";
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String city = resultSet.getString("city");

                System.out.println("Student ID: " + id + " \n Student Name: " + name + " \nStudent Phone: " + phone + " \nStudent city: " + city);
                System.out.println("----------------------------------------------");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }


    }
}
