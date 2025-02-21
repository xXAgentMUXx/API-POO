package com.example.demo;

public abstract class Person {
    private String name;
    private int age;
    private int StudentID;

    public Person(String name, int age, int StudentID) {
        this.name = name;
        this.age = age;
        this.StudentID = StudentID;
    }
     public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getStudentID() {
        return StudentID;
    }
    public static void main(String[] args) {
    
        Student student = new Student("Axel", 20, 1045);
        System.out.println("Nom : " + student.getName());
        System.out.println("Âge : " + student.getAge());
        System.out.println("ID étudiant : " + student.getStudentID());
    }
} // faites la commande "cd demo" puis, ".\gradlew.bat bootRun" pour executer la page