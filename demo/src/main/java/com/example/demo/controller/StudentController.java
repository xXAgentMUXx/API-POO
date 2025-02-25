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
    
    private final StudentService studentService;
    private final studentRepository studentRepository;

    public StudentController(StudentService studentService, studentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository= studentRepository;
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student_id = studentService.getStudentById(id);
        return student_id != null ? ResponseEntity.ok(student_id) : ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
    return ResponseEntity.noContent().build();
    }
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
/*  Command to update student : Invoke-WebRequest -Uri "http://localhost:8080/students/1" -Method Put `
-Headers @{"Content-Type"="application/json"} `
-Body '{"name":"Nouveau Nom","age":25,"studentId":1234}'*/