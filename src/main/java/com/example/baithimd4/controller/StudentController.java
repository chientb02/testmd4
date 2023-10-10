package com.example.baithimd4.controller;

import com.example.baithimd4.model.Classroom;
import com.example.baithimd4.model.Student;
import com.example.baithimd4.repository.IClassroom;
import com.example.baithimd4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")

public class StudentController {
    @Autowired
    private IStudentService studentService ;
    @Autowired
    private IClassroom classroomService ;

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/classroom")
    public ResponseEntity<Iterable<Classroom>> findAllClassroom() {
        return new ResponseEntity<>(classroomService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findOne(@PathVariable Long id) {
        Optional<Student> user = studentService.findOne(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idStudent}")
    public ResponseEntity<Student> delete(@PathVariable("idStudent") Long idStudent) {
        Optional<Student> studentOptional = studentService.findOne(idStudent);
        if (studentOptional.isPresent()) {
            studentService.delete(idStudent);
            return new ResponseEntity<>(studentOptional.get(), HttpStatus.NO_CONTENT);
        }return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<?> searchByName(@PathVariable String search){
        return new ResponseEntity<>(studentService.findByName(search),HttpStatus.OK);
    }

}
