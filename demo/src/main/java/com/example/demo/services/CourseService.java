package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}