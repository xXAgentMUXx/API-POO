package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Student;
import com.example.demo.repository.studentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

     // Dependency injection of the studentRepository
    private final studentRepository studentRepository;

     // Constructor to inject the repository
    public StudentService(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
     // Method to create a new student (and save it)
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    // Method to get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    // Method to save or update a student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
     // Method to get a student by its id
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
     // Method to delete a student by its id
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
     // Method to delete all data
    @Transactional
    public void deleteAll() {
        studentRepository.deleteAll();
    }
    // Method to delete all students
    @Transactional
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}