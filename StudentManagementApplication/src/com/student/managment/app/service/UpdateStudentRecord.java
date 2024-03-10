package com.student.managment.app.service;

import com.student.managment.app.model.Student;

public interface UpdateStudentRecord {
    public  boolean updateStudentRecord(int val, String toUpdate,int id, Student st);
}
