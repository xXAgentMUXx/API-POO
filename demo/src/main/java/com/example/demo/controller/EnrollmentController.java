package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Enrollment;
import com.example.demo.services.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }
    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllCourses() {
    return ResponseEntity.ok(enrollmentService.getAllEnrollment());
    }

    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        return ResponseEntity.ok(enrollmentService.enrollStudent(studentId, courseId));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long id) {
    enrollmentService.deleteEnrollment(id);
        return ResponseEntity.ok("Enrollment deleted successfully.");
    }
}