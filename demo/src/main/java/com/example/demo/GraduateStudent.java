package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Graduate")
public class GraduateStudent extends Student {
    // Default constructor
    public GraduateStudent() {}

    // Constructor to initialize properties
    public GraduateStudent(String name, int age, int studentID) {
        super(name, age, studentID);
        this.setGraduated(true); 
    }
    // Method for the average grade for graduate
    @Override
    public double getAverageGrade() {
        double average = super.getAverageGrade() + 2; 
        return Math.min(average, 20);
    }
    // Method to go to graduate at Undergraduate
    public void downgradeToUndergraduate() {
        this.setGraduated(false);
    }
    public static void main(String[] args) {
        GraduateStudent gradeStudent = new GraduateStudent("Vito", 25, 2001);
        gradeStudent.addGrade(12.8);
        gradeStudent.addGrade(12.5);
        gradeStudent.addGrade(18.7);

        System.out.println("Nom : " + gradeStudent.getName());
        System.out.println("ID : " + gradeStudent.getStudentID());
        System.out.println("Moyenne : " + gradeStudent.getAverageGrade());
    }
} 
