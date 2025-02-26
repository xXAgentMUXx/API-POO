package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Course;
import com.example.demo.Enrollment;
import com.example.demo.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.studentRepository;

import jakarta.transaction.Transactional;

@Service
public class EnrollmentService {

    // Dependencies on repositories
    private final EnrollmentRepository enrollmentRepository;
    private final studentRepository studentRepository;
    private final CourseRepository courseRepository;

      // Constructor to inject repositories
    public EnrollmentService(EnrollmentRepository enrollmentRepository, studentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
      // Method to retrieve all enrollments
    public List<Enrollment> getAllEnrollment() {
        return enrollmentRepository.findAll();
    }
     // Method to enroll a student in a course
    public Enrollment enrollStudent(Long studentId, Long courseId) {
        // Searching for the student and course in the database
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

         // If the student or course doesn't exist, return null
        if (student == null || course == null) {
            return null;
        }
        // Creating Enrollment and saving it to the database
        Enrollment enrollment = new Enrollment(student, course);
        return enrollmentRepository.save(enrollment);
    }
      // Method to delete an enrollment by its ID
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
     // Method to delete all data
    @Transactional
    public void deleteAll() {
        enrollmentRepository.deleteAll();
    }
     // Method to delete all enrollments
    @Transactional
    public void deleteAllEnrollments() {
        enrollmentRepository.deleteAll();
    }
}
