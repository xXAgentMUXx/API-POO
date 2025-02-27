package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    // all properties for the class Person
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    // Default constructor
    public Person() {}

    // Constructor to initialize the properties
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
     // getter for id
    public Long getId() {
        return id;
    }
    // getter and setter for Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // getter and setter for Age
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
     public static void main(String[] args) {
    
        Student student = new Student("Axel", 20, 1045);
        System.out.println("Nom : " + student.getName());
        System.out.println("Âge : " + student.getAge());
        System.out.println("ID étudiant : " + student.getStudentID());
    }
} 
