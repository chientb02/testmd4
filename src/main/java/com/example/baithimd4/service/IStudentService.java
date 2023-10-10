package com.example.baithimd4.service;

import com.example.baithimd4.model.Student;

public interface IStudentService extends IGenerateService<Student> {
    Iterable<Student> findByName(String name);
}
