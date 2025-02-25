package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public Enrollment() {}

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.register();
    }
    public Long getId() {
        return id;
    }
    public Course getCourse() {
        return course;
    }
    public Student getStudent() {
        return student;
    }
    public void register() {
        course.enrollStudent(student);
    }
} // Command "cd demo" then, "./gradlew.bat bootRun" to execute the page

/*Command POST :
 Invoke-WebRequest -Uri "http://localhost:8080/enrollments" -Method Post `
-Headers @{"Content-Type"="application/x-www-form-urlencoded"} `
-Body "studentId=1&courseId=1"

Command Delete : Invoke-WebRequest -Uri "http://localhost:8080/enrollments/1" -Method Delete
 */