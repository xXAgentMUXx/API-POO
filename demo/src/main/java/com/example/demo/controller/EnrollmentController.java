package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Enrollment;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.studentRepository;
import com.example.demo.services.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final CourseRepository courseRepository;
    private final studentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentController(EnrollmentService enrollmentService, CourseRepository courseRepository, studentRepository studentRepository, EnrollmentRepository enrollmentRepository) {
        this.enrollmentService = enrollmentService;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
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
    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Map<String, Long> updateDetails) {
        return enrollmentRepository.findById(id).flatMap(enrollment -> 
        studentRepository.findById(updateDetails.get("studentId"))
            .flatMap(newStudent -> courseRepository.findById(updateDetails.get("courseId"))
                .map(newCourse -> {
                    enrollment.setStudent(newStudent);
                    enrollment.setCourse(newCourse);
                    enrollmentRepository.save(enrollment);
                    return ResponseEntity.ok(enrollment);
                })
            )
    ).orElse(ResponseEntity.notFound().build());
    }
}
/*  command to update Enrollment : Invoke-WebRequest -Uri "http://localhost:8080/enrollments/1" -Method Put `
-Headers @{"Content-Type"="application/json"} `
-Body '{"studentId":2, "courseId":3}'*/