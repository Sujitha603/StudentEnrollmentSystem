package com.jdbc.main;

import com.jdbc.dto.StudentDTO;
import com.jdbc.service.StudentService;
import com.jdbc.service.impl.StudentServiceImpl;
import com.jdbc.util.InputUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentServiceImpl();

        while (true) {

            System.out.println("\n===== Student Enrollment System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Find Student By Id");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Student");
            System.out.println("5. View All Students");
            System.out.println("6. Search By Email & Enrollment Date");
            System.out.println("7. Exit");

            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    StudentDTO student = InputUtil.acceptStudentDetails();

                    if (service.saveStudent(student)) {
                        System.out.println("Student Added Successfully...");
                    } else {
                        System.out.println("Failed to Add Student...");
                    }
                    break;

                case 2:

                    System.out.print("Enter Student Id : ");
                    int id = sc.nextInt();

                    StudentDTO s = service.findStudentById(id);

                    if (s != null) {
                        System.out.println(s);
                    } else {
                        System.out.println("Student Not Found...");
                    }
                    break;

                case 3:

                    System.out.print("Enter Student Id : ");
                    int studentId = sc.nextInt();

                    System.out.print("Enter New Course Id : ");
                    int courseId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course Name : ");
                    String courseName = sc.nextLine();

                    if (service.updateCourse(studentId, courseId, courseName)) {
                        System.out.println("Course Updated Successfully...");
                    } else {
                        System.out.println("Update Failed...");
                    }
                    break;

                case 4:

                    System.out.print("Enter Student Id : ");
                    int deleteId = sc.nextInt();

                    if (service.deleteStudent(deleteId)) {
                        System.out.println("Student Deleted Successfully...");
                    } else {
                        System.out.println("Student Not Found...");
                    }
                    break;

                case 5:

                    List<StudentDTO> students = service.findAllStudents();

                    if (students.isEmpty()) {
                        System.out.println("No Records Found...");
                    } else {
                        for (StudentDTO std : students) {
                            System.out.println(std);
                        }
                    }
                    break;

                case 6:

                    System.out.print("Enter Email Id : ");
                    String email = sc.nextLine();

                    System.out.print("Enter Enrollment Date (yyyy-MM-dd) : ");
                    LocalDate date = LocalDate.parse(sc.nextLine());

                    StudentDTO result = service.findByEmailAndEnrollmentDate(email, date);

                    if (result != null) {
                        System.out.println(result);
                    } else {
                        System.out.println("Student Not Found...");
                    }
                    break;

                case 7:

                    System.out.println("Thank You...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice...");
            }
        }
    }
}
