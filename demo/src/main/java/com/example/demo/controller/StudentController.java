package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Student;
import com.example.demo.repository.studentRepository;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    // Injecting services and repository for student data
    private final StudentService studentService;
    private final studentRepository studentRepository;

    // Constructors to initialize services and repository
    public StudentController(StudentService studentService, studentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository= studentRepository;
    }
    // Post request for creating a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }
    // Get request to get the data from student by it's id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student_id = studentService.getStudentById(id);
        return student_id != null ? ResponseEntity.ok(student_id) : ResponseEntity.notFound().build();
    }
    // Get request to get all the data from course
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    // Delete request to suppres the data from student by it's id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
    return ResponseEntity.noContent().build();
    }
    // Put request to update the data from student by it's id
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        student.setStudentID(studentDetails.getStudentID());
        studentRepository.save(student);
            return ResponseEntity.ok(student);
        }).orElse(ResponseEntity.notFound().build());
    }
}