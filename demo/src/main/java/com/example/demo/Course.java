package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Course  {

    private String CourseName;
    private int CreditHours;
    private String courseCode;
    private List<Student> students;

    public Course(String CourseName, String courseCode, int CreditHours) {
    this.CourseName = CourseName;
    this.courseCode = courseCode;
    this.CreditHours = CreditHours;
    this.students = new ArrayList<>();
    }
    public int getCreditHours() {
        return CreditHours;
    }
    public void setCreditHours(int CreditHours) {
        this.CreditHours = CreditHours;
    }
    public String getCourseName() {
        return CourseName;
    }
    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void enrollStudent(Student student) {
        students.add(student);
    }
      public List<Student> getEnrolledStudents() {
        return students;
    }
    public static void main(String[] args) {
    Course course = new Course("Mathématiques", "MATHS_101", 3);
        
        Student student1 = new Student("Mathys", 20, 1001);
        Student student2 = new Student("Axel", 22, 1452);
        Student student3 = new Student("Vito", 21, 4521);

        course.enrollStudent(student1);
        course.enrollStudent(student2);
        course.enrollStudent(student3);

        System.out.println("Étudiants inscrits au cours " + course.getCourseName() + " :");
        for (Student s : course.getEnrolledStudents()) {
            System.out.println("- Name : " + s.getName() + ", ID : "+ s.getStudentID());
        }
    }
} // faites la commande "cd demo" puis, ".\gradlew.bat bootRun" pour executer la page