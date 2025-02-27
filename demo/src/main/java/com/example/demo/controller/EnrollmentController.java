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

import com.example.demo.Course;
import com.example.demo.Enrollment;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.studentRepository;
import com.example.demo.services.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    // Injecting services and repository required for handling enrollments-related data
    private final EnrollmentService enrollmentService;
    private final CourseRepository courseRepository;
    private final studentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;

    // Constructors to initialize services and repository
    public EnrollmentController(EnrollmentService enrollmentService, CourseRepository courseRepository, studentRepository studentRepository, EnrollmentRepository enrollmentRepository) {
        this.enrollmentService = enrollmentService;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
    }
    // Get request to get all the data from enrollments
    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllCourses() {
    return ResponseEntity.ok(enrollmentService.getAllEnrollment());
    }
    // Post request for creating a new enrollment
    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        return ResponseEntity.ok(enrollmentService.enrollStudent(studentId, courseId));
    }
    // Delete request to suppres the data from enrollments by its id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long id) {
    enrollmentService.deleteEnrollment(id);
        return ResponseEntity.ok("Enrollment deleted successfully.");
    }
    // Put request to update the data from enrollments by its id
    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Map<String, Long> updateDetails) {
        return enrollmentRepository.findById(id).flatMap(enrollment -> 
            studentRepository.findById(updateDetails.get("studentId"))
                .flatMap(newStudent -> courseRepository.findById(updateDetails.get("courseId"))
                    .map(newCourse -> {
                        // Delete the old student from course
                        Course oldCourse = enrollment.getCourse();
                        if (oldCourse != null) {
                            oldCourse.getEnrolledStudents().remove(enrollment.getStudent());
                            courseRepository.save(oldCourse);
                        }
                        // Check student if it is created
                        if (!newCourse.getEnrolledStudents().contains(newStudent)) {
                            newCourse.getEnrolledStudents().add(newStudent);
                        }
                        // Update enrollment
                        enrollment.setStudent(newStudent);
                        enrollment.setCourse(newCourse);
                        // Save the update
                        courseRepository.save(newCourse);
                        enrollmentRepository.save(enrollment);
                        
                        return ResponseEntity.ok(enrollment);
                    })
                )
        ).orElse(ResponseEntity.notFound().build());
    }
}
