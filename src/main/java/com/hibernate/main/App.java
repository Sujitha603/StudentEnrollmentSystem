package com.hibernate.main;

import com.hibernate.entity.Student;
import com.hibernate.enums.CourseType;
import com.hibernate.enums.Gender;
import com.hibernate.enums.Grade;
import com.hibernate.service.StudentService;
import com.hibernate.service.impl.StudentServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentServiceImpl();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student");
            System.out.println("3. Get All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    Student student = new Student();

                    System.out.print("First Name: ");
                    student.setFirstName(sc.nextLine());

                    System.out.print("Last Name: ");
                    student.setLastName(sc.nextLine());

                    System.out.print("Gender (MALE/FEMALE/OTHER): ");
                    student.setGender(Gender.valueOf(sc.nextLine().toUpperCase()));

                    System.out.print("City: ");
                    student.setCity(sc.nextLine());

                    System.out.print("State: ");
                    student.setState(sc.nextLine());

                    System.out.print("Mobile Number: ");
                    student.setMobileNumber(sc.nextLine());

                    System.out.print("Email Id: ");
                    student.setEmailId(sc.nextLine());

                    System.out.print("Course Id: ");
                    student.setCourseId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Course Name: ");
                    student.setCourseName(sc.nextLine());

                    student.setEnrollmentDate(LocalDate.now());

                    System.out.print("Course Type (JAVA/PYTHON/DEVOPS/DATA_SCIENCE): ");
                    student.setCourseType(CourseType.valueOf(sc.nextLine().toUpperCase()));

                    System.out.print("Grade (A/B/C/D/F): ");
                    student.setGrade(Grade.valueOf(sc.nextLine().toUpperCase()));

                    service.addStudent(student);

                    System.out.println("Student Added Successfully.");
                    break;

                case 2:

                    System.out.print("Enter Student id: ");
                    UUID id = UUID.fromString(sc.nextLine());

                    Student s = service.getStudent(id);

                    if (s != null) {
                        System.out.println("ID : " + s.getId());
                        System.out.println("Name : " + s.getFirstName() + " " + s.getLastName());
                        System.out.println("Gender : " + s.getGender());
                        System.out.println("City : " + s.getCity());
                        System.out.println("State : " + s.getState());
                        System.out.println("Course : " + s.getCourseName());
                        System.out.println("Grade : " + s.getGrade());
                    } else {
                        System.out.println("Student Not Found.");
                    }

                    break;

                case 3:

                    List<Student> list = service.getAllStudents();

                    for (Student st : list) {
                        System.out.println("--------------------------------");
                        System.out.println("ID : " + st.getId());
                        System.out.println("Name : " + st.getFirstName() + " " + st.getLastName());
                        System.out.println("City : " + st.getCity());
                        System.out.println("Course : " + st.getCourseName());
                        System.out.println("Grade : " + st.getGrade());
                    }

                    break;

                case 4:

                    System.out.print("Enter Student UUID: ");
                    UUID updateId = UUID.fromString(sc.nextLine());

                    Student updateStudent = service.getStudent(updateId);

                    if (updateStudent != null) {

                        System.out.print("New City: ");
                        updateStudent.setCity(sc.nextLine());

                        System.out.print("New State: ");
                        updateStudent.setState(sc.nextLine());

                        service.updateStudent(updateStudent);

                        System.out.println("Student Updated Successfully.");
                    } else {
                        System.out.println("Student Not Found.");
                    }

                    break;

                case 5:

                    System.out.print("Enter Student UUID: ");
                    UUID deleteId = UUID.fromString(sc.nextLine());

                    service.deleteStudent(deleteId);

                    System.out.println("Student Deleted Successfully.");

                    break;

                case 6:

                    System.out.println("Thank You...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}
