package com.hibernate.repository;

import com.hibernate.entity.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository {

    void save(Student student);

    Optional<Student> findById(UUID id);

    List<Student> findAll();

    void update(Student student);

    void deleteById(UUID id);
}
