package com.example.demo;

public class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name, int age, int studentID) {
        super(name, age, studentID);
    }
    @Override
    public double getAverageGrade() {
    return super.getAverageGrade() - 2;
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
} // faites la commande "cd demo" puis, ".\gradlew.bat bootRun" pour executer la page