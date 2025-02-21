package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private int age;
    private String name;
    private int StudentID;
    private List<Double> grades;


    public Student(String name, int age, int StudentID) {
        super(name, age, StudentID);
        this.age = age;
        this.name = name;
        this.StudentID = StudentID;
        this.grades = new ArrayList<>();
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
    @Override
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
} // faites la commande "cd demo" puis, ".\gradlew.bat" bootRun pour executer la page