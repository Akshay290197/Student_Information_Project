package com.example.Student.service;

import com.example.Student.model.Student;

import java.util.List;

public interface StudentService {
    public Student addStudent(Student student);
    public Student getStudent(int studid);
    public List<Student> getAllStudent();
    public Student updateStudent(int studid, Student student);
    public boolean deleteStudent(int studid);
}
