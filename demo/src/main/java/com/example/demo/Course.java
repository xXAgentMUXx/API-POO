package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {
    // all properties for the class Course
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("courseName")
    private String courseName;
    @JsonProperty("courseCode")
    private String courseCode;
    @JsonProperty("creditHours")
    private int creditHours;
    @ManyToMany
    private List<Student> Students = new ArrayList<>();

    // Default constructor
    public Course() {}

    // Constructor to initialize the properties
    public Course(String courseName, String courseCode, int creditHours) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        }
        // getter for student
        @JsonProperty("Students")
        public List<Student> getEnrolledStudents() {
        return Students;
        }
        // getter for id
        public Long getId() {
        return id;
        }
        // getter and setter for creditHours
        public int getCreditHours() {
            return creditHours;
        }
        public void setCreditHours( int creditHours) {
            this.creditHours = creditHours;
        }
        // getter and setter for CourseName
        public String getCourseName() {
            return courseName;
        }
        public void setCourseName( String courseName) {
            this.courseName =  courseName;
        }
        // getter and setter for courseCode
        public String getCourseCode() {
            return courseCode;
        }
        public void setCourseCode( String courseCode) {
            this.courseCode =  courseCode;
        }
        // Method to enroll a student in a new course
        public void enrollStudent(Student student) {
            Students.add(student);
        }
    public static void main(String[] args) {
    Course course = new Course("Mathématiques", "MATHS_101", 3);

        Student student1 = new Student("Mathys", 20, 1001);
        Student student2 = new Student("Axel", 22, 1452);
        Student student3 = new Student("Vito", 21, 4521);

        course.enrollStudent(student1);
        course.enrollStudent(student2);
        course.enrollStudent(student3);

        System.out.println("Étudiants inscrits au cours " + course.getCourseName() + " :");
        for (Student s : course.getEnrolledStudents()) {
            System.out.println("- Name : " + s.getName() + ", ID : "+ s.getStudentID());
        }
    }
} 
