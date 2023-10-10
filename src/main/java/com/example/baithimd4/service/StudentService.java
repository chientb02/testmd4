package com.example.baithimd4.service;

import com.example.baithimd4.model.Student;
import com.example.baithimd4.repository.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudent studentRepo ;
    @Override
    public Iterable<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> findOne(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student) ;
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Iterable<Student> findByName(String name) {
        return studentRepo.findAllByNameContaining(name);
    }
}
