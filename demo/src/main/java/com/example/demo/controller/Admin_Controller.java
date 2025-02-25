package com.example.demo.controller;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CourseService;
import com.example.demo.services.EnrollmentService;
import com.example.demo.services.StudentService;

@RestController
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
    // Commande pour Delete tout : Invoke-WebRequest -Uri "http://localhost:8080/admin/deleteAll" -Method Delete
    @DeleteMapping("/deleteAll") 
    public String deleteAllData() {
        enrollmentService.deleteAll();
        courseService.deleteAll();
        studentService.deleteAll();
        return "Toutes les données ont été supprimées avec succès.";
    }
    // commande pour Delete Enrollments : Invoke-WebRequest -Uri "http://localhost:8080/admin/deleteAllEnrollments" -Method Delete
    @DeleteMapping("/deleteAllEnrollments")
    public String deleteAllEnrollments() {
        enrollmentService.deleteAllEnrollments();
        return "Toutes les inscriptions étudiantes ont été supprimées avec succès.";
    }
    // commande pour Delete Course : Invoke-WebRequest -Uri "http://localhost:8080/admin/deleteAllCourses" -Method Delete
    @DeleteMapping("/deleteAllCourses")
    public String deleteAllCourses() {
        courseService.deleteAllCourses();
        return "Tous les cours ont été supprimés avec succès.";
    }
    // commande pour Delete Students : Invoke-WebRequest -Uri "http://localhost:8080/admin/deleteAllStudents" -Method Delete
    @DeleteMapping("/deleteAllStudents")
    public String deleteAllStudents() {
        studentService.deleteAllStudents();
        return "Tous les étudiants ont été supprimés avec succès.";
    }
} 