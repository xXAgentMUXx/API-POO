package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Undergraduate")
public class UndergraduateStudent extends Student {
    // Default constructor
    public UndergraduateStudent() {}
     // Constructor to initialize the properties
    public UndergraduateStudent(String name, int age, int studentID) {
        super(name, age, studentID);
    }
    // Method to modify the behavior for UndergraduateStudent
    @Override
    public double getAverageGrade() {
        double average = super.getAverageGrade() - 2;
        if (average <= 0) {
            return 0;
        }
            return average;
        }
    public static void main(String[] args) {
        UndergraduateStudent gradeStudent = new UndergraduateStudent("Mathys", 25, 2001);
        gradeStudent.addGrade(17.9);
        gradeStudent.addGrade(18.8);
        gradeStudent.addGrade(19.7);

        System.out.println("Nom : " + gradeStudent.getName());
        System.out.println("ID : " + gradeStudent.getStudentID());
        System.out.println("Moyenne : " + gradeStudent.getAverageGrade());
    }
} 
