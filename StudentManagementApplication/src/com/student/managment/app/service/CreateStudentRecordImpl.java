package com.student.managment.app.service;

import com.student.managment.app.config.ConnectionProvider;
import com.student.managment.app.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class CreateStudentRecordImpl implements CreateStudentRecord{

    @Override
    public boolean insertStudent(Student st){
        boolean f = false;
        try {
            Connection connection = ConnectionProvider.getConnection();
            String query = "insert into student(id, name, mobile_no,city) values(?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            //set the value of parameters
            pstmt.setInt(1, st.getStudentID());
            pstmt.setString(2, st.getStudentName());
            pstmt.setInt(3, Integer.parseInt(st.getStudentPhone()));
            pstmt.setString(4, st.getStudentCity());

            //execute..
            pstmt.executeUpdate();

            f = true;
        } catch (Exception e) {

        }
        return f;
    }
}
