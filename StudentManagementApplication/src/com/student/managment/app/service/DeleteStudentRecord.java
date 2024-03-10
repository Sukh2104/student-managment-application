package com.student.managment.app.service;

import com.student.managment.app.config.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface DeleteStudentRecord {
    public boolean deleteStudent(int id);
}
