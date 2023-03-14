package com.example.Student.service;

import com.example.Student.model.Student;
import com.example.Student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student addStudent(Student student) {
        if(studentRepo.findById(student.getStudid()).isPresent()){
            return null;
        }
        else{
            return studentRepo.save(student);
        }
    }

    @Override
    public Student getStudent(int studid) {
        if(studentRepo.findById(studid).isPresent()){
            return studentRepo.findById(studid).get();
        }
        else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student updateStudent(int studid, Student student) {
        if(studentRepo.findById(studid).isPresent()){
            return studentRepo.save(student);
        }
        else{
            return null;
        }
    }

    @Override
    public boolean deleteStudent(int studid) {
        boolean status=false;
        if(studentRepo.findById(studid).isPresent()){
            studentRepo.deleteById(studid);
            status=true;
        }
        else{
            status=false;
        }
        return status;
    }
}
