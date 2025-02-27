package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Graduate")
public class GraduateStudent extends Student {
     // Default constructor
    public GraduateStudent() {}
    // Constructor to initialize the properties
    public GraduateStudent(String name, int age, int studentID) {
        super(name, age, studentID);
    }
    // Method to modify the behavior for GraduateStudent
    @Override
    public double getAverageGrade() {
        double average = super.getAverageGrade() + 2;
        if (average >= 20) {
            return 20;
        }
        return average;
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
