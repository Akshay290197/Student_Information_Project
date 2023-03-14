package com.example.Student.controller;

import com.example.Student.model.Student;
import com.example.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/get/{studid}")
    public ResponseEntity<?> getStud(@PathVariable int studid){
        return new ResponseEntity<>(studentService.getStudent(studid),HttpStatus.OK);
    }

    @GetMapping("/get/data")
    public ResponseEntity<?> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.OK);
    }

    @PutMapping("/update/{studid}")
    public ResponseEntity<?> updateStudent(@PathVariable int studid, @RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(studid,student),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{studid}")
    public ResponseEntity<?> deleteStudent(@PathVariable int studid){
        System.out.println("student id is :"+ studid);
        return new ResponseEntity<>(studentService.deleteStudent(studid),HttpStatus.OK);
    }
}
