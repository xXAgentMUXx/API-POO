package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Course;
import com.example.demo.repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseService {

    //Injecting services and repository
    private final CourseRepository courseRepository;

    // Constructors to initialize repository
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    // Method to display all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    // Method to create a new courses
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
    // Method to save a course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    // Method to get a course by it's id
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
    // Method to suppress a course by it's id
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    // Method to suppress all data
    @Transactional
    public void deleteAll() {
        courseRepository.deleteAll();
    }
    // Method to suppress all data from course
    @Transactional
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }
}
