package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Student;
import com.example.demo.repository.studentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    private final studentRepository studentRepository;

    public StudentService(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    @Transactional
    public void deleteAll() {
        studentRepository.deleteAll();
    }
}