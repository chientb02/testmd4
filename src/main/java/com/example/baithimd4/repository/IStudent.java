package com.example.baithimd4.repository;

import com.example.baithimd4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudent extends JpaRepository<Student, Long> {
    Iterable<Student> findAllByNameContaining(String search);
}
