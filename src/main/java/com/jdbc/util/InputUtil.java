package com.jdbc.util;

import com.jdbc.dto.StudentDTO;
import com.jdbc.enums.CourseType;
import com.jdbc.enums.Gender;
import com.jdbc.enums.Grade;

import java.time.LocalDate;
import java.util.Scanner;

public class InputUtil {

    private static final Scanner sc = new Scanner(System.in);

    public static StudentDTO acceptStudentDetails() {

        StudentDTO student = new StudentDTO();

        System.out.print("Enter Id : ");
        student.setId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter First Name : ");
        student.setFirstName(sc.nextLine());

        System.out.print("Enter Last Name : ");
        student.setLastName(sc.nextLine());

        System.out.print("Enter Gender (MALE/FEMALE/OTHER) : ");
        student.setGender(Gender.valueOf(sc.nextLine().toUpperCase()));

        System.out.print("Enter City : ");
        student.setCity(sc.nextLine());

        System.out.print("Enter State : ");
        student.setState(sc.nextLine());

        System.out.print("Enter Mobile Number : ");
        student.setMobileNumber(sc.nextLine());

        System.out.print("Enter Email Id : ");
        student.setEmailId(sc.nextLine());

        System.out.print("Enter Course Id : ");
        student.setCourseId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Course Name : ");
        student.setCourseName(sc.nextLine());

        System.out.print("Enter Enrollment Date (yyyy-MM-dd) : ");
        student.setEnrollmentDate(LocalDate.parse(sc.nextLine()));

        System.out.print("Enter Course Type (ONLINE/OFFLINE/HYBRID) : ");
        student.setCourseType(CourseType.valueOf(sc.nextLine().toUpperCase()));

        System.out.print("Enter Grade (A/B/C/D/F) : ");
        student.setGrade(Grade.valueOf(sc.nextLine().toUpperCase()));

        return student;
    }
}
