package com.student.managment.app.model;

public class Student {
    private int studentID;
    private String studentName;
    private String studentPhone;
    private String studentCity;

    public Student(int studentID, String studentName, String studentPhone, String studentCity) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentCity = studentCity;
    }

    public Student() {

    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentCity() {
        return studentCity;
    }
    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }
}
