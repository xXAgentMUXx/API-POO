package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.services.CourseService;

@RestController
// URL mapping for course endpoints
@RequestMapping("/courses")
@CrossOrigin(origins = "*")  
public class CourseController {

    // Injecting services and repository required for handling course-related data
    private final CourseService courseService;
    private final CourseRepository courseRepository;

    // Constructors to initialize services and repository
    public CourseController(CourseService courseService, CourseRepository courseRepository) {
        this.courseService = courseService;
        this.courseRepository = courseRepository;
    }
    // Post request for creating a new course
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }
    // Get request to get all the data from course
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
    // Get request to get the data from course by it's id
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }
    // Delete request to suppres the data from course by it's id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
    courseService.deleteCourse(id);
    return ResponseEntity.noContent().build();
    }
    // Put request to update the data from course by it's id
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseRepository.findById(id).map(course -> {
        course.setCourseName(courseDetails.getCourseName());
        course.setCourseCode(courseDetails.getCourseCode());
        course.setCreditHours(courseDetails.getCreditHours());
        courseRepository.save(course);
        return ResponseEntity.ok(course);
    }).orElse(ResponseEntity.notFound().build());
    }
}
