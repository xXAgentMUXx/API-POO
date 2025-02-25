package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Person {

    private int studentID;
    
    @ElementCollection
    private List<Double> grades = new ArrayList<>();

    public Student() {}

    public Student(String name, int age, int studentID) {
        super(name, age); 
        this.studentID = studentID;
    }
    public List<Double> getGrades() {
        return grades;
    }
    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }
    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public void addGrade(double grade) {
        grades.add(grade);
    }
    public double getAverageGrade() {
        if (grades.isEmpty()) { 
            return 0;
        }
        double somme = 0;
        for (double grade : grades) {
            somme += grade;
        }
        return somme / grades.size();
    }
    public static void main(String[] args) {
        Student student = new Student("Alex", 24, 100);
        
        student.addGrade(15.3);
        student.addGrade(15.8);
        student.addGrade(8.7);
        
        System.out.println("Moyenne des notes de " +" ( ID : " + student.getStudentID() + " ) : " + student.getAverageGrade());
    }
} // Command "cd demo" then, "./gradlew.bat bootRun" to execute the page

/*Command POST (with json files) :

Invoke-WebRequest -Uri "http://localhost:8080/students" -Method Post `
-Headers @{"Content-Type"="application/json"; "charset"="utf-8"} `
 -Body ([System.Text.Encoding]::UTF8.GetBytes((Get-Content -Raw -Path "student.json")))

Command POST (whitout json files) :

Invoke-WebRequest -Uri "http://localhost:8080/students" -Method Post `
-Headers @{"Content-Type"="application/json"} `
-Body '{"name":"John Doe","age":21,"studentID":12345,"grades":[14,16,12,18,15]}'
 */

 //Command GET : Invoke-WebRequest -Uri "http://localhost:8080/students/1" -Method Get

 // Command Delete : Invoke-WebRequest -Uri "http://localhost:8080/students/1" -Method Delete
