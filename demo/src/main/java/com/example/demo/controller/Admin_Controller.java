package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CourseService;
import com.example.demo.services.EnrollmentService;
import com.example.demo.services.StudentService;

@RestController
// request to this URL for this controller
@RequestMapping("/admin")
public class Admin_Controller {
    private final EnrollmentService enrollmentService;
    private final CourseService courseService;
    private final StudentService studentService;

    public Admin_Controller(EnrollmentService enrollmentService, CourseService courseService, StudentService studentService) {
        this.enrollmentService = enrollmentService;
        this.courseService = courseService;
        this.studentService = studentService;
    }
    // Endpoint to delete all data (students, courses, enrollments)
    @DeleteMapping("/deleteAll") 
    public String deleteAllData() {
        enrollmentService.deleteAll();
        courseService.deleteAll();
        studentService.deleteAll();
        return "All data has been successfully deleted.";
    }
    // Endpoint to delete all data from enrollments
    @DeleteMapping("/deleteAllEnrollments")
    public String deleteAllEnrollments() {
        enrollmentService.deleteAllEnrollments();
        return "All student registrations have been successfully removed.";
    }
     // Endpoint to delete all data from courses
    @DeleteMapping("/deleteAllCourses")
    public String deleteAllCourses() {
        courseService.deleteAllCourses();
        return "All courses have been successfully deleted.";
    }
    // Endpoint to delete all data from students
    @DeleteMapping("/deleteAllStudents")
    public String deleteAllStudents() {
        studentService.deleteAllStudents();
        return "All students have been successfully deleted.";
    }
} 
