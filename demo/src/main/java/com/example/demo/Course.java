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
    private List<Student> students = new ArrayList<>();

    public Course() {}

    public Course(String courseName, String courseCode, int creditHours) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
        public Long getId() {
        return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public int getCreditHours() {
            return creditHours;
        }
        public void setCreditHours(int CreditHours) {
            this.creditHours = CreditHours;
        }
        public String getCourseName() {
            return courseName;
        }
        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }
        public String getCourseCode() {
            return courseCode;
        }
        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }
        public void enrollStudent(Student student) {
            students.add(student);
        }
          public List<Student> getEnrolledStudents() {
            return students;
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
} // faites la commande "cd demo" puis, ".\gradlew.bat bootRun" pour executer la page

/* commande POST (avec json files) : 
Invoke-WebRequest -Uri "http://localhost:8080/courses" -Method Post `
-Headers @{"Content-Type"="application/json"; "charset"="utf-8"} `
-Body ([System.Text.Encoding]::UTF8.GetBytes((Get-Content -Raw -Path "data.json")))

Commande POST (sans json files) :
Invoke-WebRequest -Uri "http://localhost:8080/courses" -Method Post `
-Headers @{"Content-Type"="application/json"} `
-Body '{"courseName":"Mathematiques","courseCode":"MATH101","credits":3}'*/ 

// commande GET : Invoke-WebRequest -Uri "http://localhost:8080/courses" -Method Get

// commande suppress : Invoke-WebRequest -Uri "http://localhost:8080/courses/1" -Method Delete

