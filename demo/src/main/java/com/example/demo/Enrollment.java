package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {
    // all properties for the class Enrollment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    // Default constructor
    public Enrollment() {}

    // Constructor to initialize the properties
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.register();
    }
    // getter for id
    public Long getId() {
        return id;
    }
    // getter and setter for Course
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    // getter and setter for Student
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
     // Method to link a student in a course
    public void register() {
        course.enrollStudent(student);
    }
} 
