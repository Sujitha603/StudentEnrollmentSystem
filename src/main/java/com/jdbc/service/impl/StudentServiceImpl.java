package com.jdbc.service.impl;

import com.jdbc.dto.StudentDTO;
import com.jdbc.repository.StudentRepository;
import com.jdbc.repository.impl.StudentRepositoryImpl;
import com.jdbc.service.StudentService;

import java.time.LocalDate;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public boolean saveStudent(StudentDTO student) {
        return repository.saveStudent(student);
    }

    @Override
    public StudentDTO findStudentById(int id) {
        return repository.findStudentById(id);
    }

    @Override
    public boolean updateCourse(int id, int courseId, String courseName) {
        return repository.updateCourse(id, courseId, courseName);
    }

    @Override
    public boolean deleteStudent(int id) {
        return repository.deleteStudent(id);
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        return repository.findAllStudents();
    }

    @Override
    public StudentDTO findByEmailAndEnrollmentDate(String emailId, LocalDate enrollmentDate) {
        return repository.findByEmailAndEnrollmentDate(emailId, enrollmentDate);
    }
}
