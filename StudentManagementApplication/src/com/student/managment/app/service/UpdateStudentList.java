package com.student.managment.app.service;

import com.student.managment.app.config.ConnectionProvider;
import com.student.managment.app.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateStudentList implements UpdateStudentRecord {
    @Override
    public boolean updateStudentRecord(int val,String toUpdate,int id, Student st)

 {

        boolean f = false;

        try {
            Connection con = ConnectionProvider.getConnection();
            if(val == 1) {
               String query = "update student set name=? where id=?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, toUpdate);
                pstmt.setInt(2, id);

                pstmt.executeUpdate();
                f = true;
            }
            else if(val == 2) {
                //Update Phone
                String query = "update student set phone=? where id=?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, toUpdate);
                pstmt.setInt(2, id);

                //execute..
                pstmt.executeUpdate();
                f = true;
            }
            else if(val == 3) {
                //Update City
                String query = "update student set city=? where id=?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, toUpdate);
                pstmt.setInt(2, id);

                //execute..
                pstmt.executeUpdate();
                f = true;

            } else {

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return f;
    }
}

