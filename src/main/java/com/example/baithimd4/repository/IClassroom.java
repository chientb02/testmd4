package com.example.baithimd4.repository;

import com.example.baithimd4.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassroom extends JpaRepository<Classroom , Long> {

}
