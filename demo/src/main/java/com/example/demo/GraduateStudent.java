package com.example.demo;

import jakarta.persistence.Entity;

@Entity
public class GraduateStudent extends Student {
    public GraduateStudent() {}
    public GraduateStudent(String name, int age, int studentID) {
        super(name, age, studentID);
    }
    @Override
    public double getAverageGrade() {
        return super.getAverageGrade() + 2;
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
} // faites la commande "cd demo" puis, ".\gradlew.bat bootRun" pour executer la page