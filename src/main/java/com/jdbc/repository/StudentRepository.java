package com.jdbc.repository;

import com.jdbc.dto.StudentDTO;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository {

    boolean saveStudent(StudentDTO student);

    StudentDTO findStudentById(int id);

    boolean updateCourse(int id, int courseId, String courseName);

    boolean deleteStudent(int id);

    List<StudentDTO> findAllStudents();

    StudentDTO findByEmailAndEnrollmentDate(String emailId, LocalDate enrollmentDate);
}
