package com.student.managment.app;

import com.student.managment.app.config.ConnectionProvider;
import com.student.managment.app.model.Student;
import com.student.managment.app.service.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class StudentManagementApplicationMain {
    public static void main(String[] args) throws SQLException {

        // TODO Auto-generated method stub
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Hello User Please Enter Your Name: ");
            String user = br.readLine();
            System.out.println("Welcome To Student Management Application " + user);
            System.out.println("\nPlease Select The Given Below Number To Perform Operations: ");
            Boolean optionFlag = true;
            while (optionFlag) {
                System.out.println("PRESS 1 to ADD student");
                System.out.println("PRESS 2 to DELETE student");
                System.out.println("PRESS 3 to DISPLAY student");
                System.out.println("PRESS 4 to UPDATE student");
                System.out.println("PRESS 5 to EXIT App");

                int selectedOption = Integer.parseInt(br.readLine());
                switch (selectedOption) {
                    case 1:
                        //Add student
                        System.out.println("Enter Student ID: ");
                        int id = Integer.parseInt(br.readLine());
                        System.out.println("Enter User Name: ");
                        String name = br.readLine();
                        System.out.println("Enter User Phone: ");
                        String phone = br.readLine();
                        System.out.println("Enter User City: ");
                        String city = br.readLine();

                        //create student object
                        Student student = new Student(id, name, phone, city);
                        CreateStudentRecord createStudentRecord = new CreateStudentRecordImpl();
                        boolean ans = createStudentRecord.insertStudent(student);
                        if (ans) {
                            System.out.println("Student record Inserted Successfully...");
                            System.out.println("Student Record:" + student);
                        } else {
                            System.out.println("Some error Occured While Inserting...Please try Again!");
                        }
                        continue;
                    case 2:
                        //Delete student
                        System.out.println("Enter Student ID To Delete: ");
                        int userID = Integer.parseInt(br.readLine());
                        DeleteStudentRecord deleteStudentRecord = new DeleteStudentRecordImpl();
                        boolean f = deleteStudentRecord.deleteStudent(userID);
                        if (f) {
                            System.out.println("Student Of ID " + userID + " Record Deleted... ");
                        } else {
                            System.out.println("Something Went Wrong.. Please try Again!");
                        }
                        continue;
                    case 3:
                        //Display student
                        ShowAllStudentRecords showAllStudents = new ShowAllStudents();
                        showAllStudents.showAllStudentRecords();
                        continue;
                    case 4:
                        //Update student
                        System.out.println("PRESS 1 to UPDATE name");
                        System.out.println("PRESS 2 to UPDATE phone");
                        System.out.println("PRESS 3 to UPDATE city");
                        int val = Integer.parseInt(br.readLine());
                        UpdateStudentRecord updateStudentRecord = new UpdateStudentList();
                        if (val == 1) {
                            //Update Name
                            System.out.println("Enter name to UPDATE...");
                            name = br.readLine();
                            System.out.println("Enter ID to identify student!");
                            id = Integer.parseInt(br.readLine());
                            Student st = new Student();
                            st.setStudentName(name);
                            boolean flage = updateStudentRecord.updateStudentRecord(val, name, id,st);
                            if (flage) {
                                System.out.println("Student Name Updated Successfully...");
                            } else {
                                System.out.println("Something Went Wrong Please try Again!");
                            }
                        } else if (val == 2) {
                            //Update Phone
                            System.out.println("Enter phone to UPDATE...");
                            phone = br.readLine();
                            System.out.println("Enter ID to identify student!");
                            id = Integer.parseInt(br.readLine());
                            Student st = new Student();
                            st.setStudentPhone(phone);
                            boolean flag = updateStudentRecord.updateStudentRecord(val, phone, id, st);
                            if (flag) {
                                System.out.println("Student Phone Updated Successfully...");
                            } else {
                                System.out.println("Something Went Wrong Please try Again!");
                            }
                        } else if (val == 3) {
                            //Update city
                            System.out.println("Enter city to UPDATE...");
                            city = br.readLine();
                            System.out.println("Enter ID to identify student!");
                            id = Integer.parseInt(br.readLine());
                            Student st = new Student();
                            st.setStudentCity(city);
                            boolean flag = updateStudentRecord.updateStudentRecord(val, city, id, st);
                            if (flag) {
                                System.out.println("Student City Updated Successfully...");
                            } else {
                                System.out.println("Something Went Wrong Please try Again!");
                            }
                        } else {
                            System.out.println("Hey You have not updated Anything... Please choose option Correctly!");
                        }
                        continue;
                    case 5:
                        //Exit
                        System.out.println("Thank You For Using Application...If You Enjoyed, Please Experience It Again!" + user);
                        optionFlag = false;
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception while performing commands: " + ex.getMessage());
        }
        System.out.println("Connection Closed Successfully.......");
    }
}
