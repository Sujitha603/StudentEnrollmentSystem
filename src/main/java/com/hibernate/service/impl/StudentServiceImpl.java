package com.hibernate.service.impl;

import com.hibernate.entity.Student;
import com.hibernate.repository.StudentRepository;
import com.hibernate.repository.impl.StudentRepositoryImpl;
import com.hibernate.service.StudentService;

import java.util.List;
import java.util.UUID;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl() {
        this.repository = new StudentRepositoryImpl();
    }

    @Override
    public void addStudent(Student student) {
        repository.save(student);
    }

    @Override
    public Student getStudent(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void updateStudent(Student student) {
        repository.update(student);
    }

    @Override
    public void deleteStudent(UUID id) {
        repository.deleteById(id);
    }
}