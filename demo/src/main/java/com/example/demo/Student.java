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
} 
