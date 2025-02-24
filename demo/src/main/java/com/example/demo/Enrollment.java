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
    /*public static void main(String[] args) {
        Course mathCourse = new Course("Mathématiques", "MATH101", 3);
        Student student1 = new Student("Alice", 22, 1001);

        Enrollment enrollment = new Enrollment(mathCourse, student1);
        enrollment.register();

        System.out.println("Etudiant inscrit : " + enrollment.getStudent().getName());
        System.out.println("Liste des etudiants en cours " + mathCourse.getCourseName() + " :");
        for (Student s : mathCourse.getEnrolledStudents()) {
            System.out.println("- " + s.getName());
        }
    }*/
} // faites la commande "cd demo" puis, ".\gradlew.bat bootRun" pour executer la page

/*Commande POST :
 Invoke-WebRequest -Uri "http://localhost:8080/enrollments" -Method Post `
-Headers @{"Content-Type"="application/x-www-form-urlencoded"} `
-Body "studentId=1&courseId=1"

commande delete : Invoke-WebRequest -Uri "http://localhost:8080/enrollments/1" -Method Delete
 */