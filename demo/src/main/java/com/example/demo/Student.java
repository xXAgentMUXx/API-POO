package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

@Entity
public class Student extends Person {

    private int age;
    private String name;
    private int StudentID;
    @ElementCollection
    private List<Double> grades = new ArrayList<>();

    public Student() {}

    public Student(String name, int age, int StudentID) {
        super(name, age);
        this.StudentID = StudentID;
    }
    @Override
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String getName() {
        return name;
    }
    public void setAge(String name) {
        this.name = name;
    }
    public int getStudentID() {
        return StudentID;
    }
    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }
    public void addGrade(double grade) {
        grades.add(grade);
    }
    public double getAverageGrade() {
        double somme = 0;
        for (double grade : grades) {
        if (grades.isEmpty()) {
            return 0;
        }
            somme += grade;
        }
        return somme / grades.size();
    }
    public static void main(String[] args) {
        Student student = new Student("Alex", 24, 100);
        
        student.addGrade(15.3);
        student.addGrade(15.8);
        student.addGrade(8.7);
        
        System.out.println("Moyenne des notes de " + student.name +" ( ID : " + student.getStudentID() + " ) : " + student.getAverageGrade());
    }
} // faites la commande "cd demo" puis, ".\gradlew.bat bootRun" pour executer la page