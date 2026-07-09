package com.hibernate.service;

import com.hibernate.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    void addStudent(Student student);

    Student getStudent(UUID id);

    List<Student> getAllStudents();

    void updateStudent(Student student);

    void deleteStudent(UUID id);
}
