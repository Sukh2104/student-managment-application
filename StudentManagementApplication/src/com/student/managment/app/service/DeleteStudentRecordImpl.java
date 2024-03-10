package com.student.managment.app.service;

import com.student.managment.app.config.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudentRecordImpl implements DeleteStudentRecord {
    @Override
    public boolean deleteStudent(int id) {
        boolean flage = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "delete from student where id=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            //set the value of parameters
            pstmt.setInt(1, id);

            //execute..
            int output = pstmt.executeUpdate();
            if (output == 1) {
                flage = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred while deleting record : "+e.getMessage());
        }
        return flage;
    }
}
