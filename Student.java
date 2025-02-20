
import java.util.ArrayList;
import java.util.List;

public class Student {

    private int age;
    private String name;
    private int StudentID;

    private static final List<Integer> grades = new ArrayList<>();

    public Student(String name, int age, int StudentID, int grades) {
        this.age = age;
        this.name = name;
        this.StudentID = StudentID;
    }
    public static List<Integer> getGrades() {
        return grades;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
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
    public void addGrade(int grade) {
        grades.add(grade);
    }
    public float getAverageGrade() {
        float somme = 0;
        for (int grade : grades) {
        if (grades.isEmpty()) {
            return 0;
        }
            somme += grade;
        }
        return somme / grades.size();
    }
    public static void main(String[] args) {
        Student student = new Student("Alice", 24, 20, 3);
        
        student.addGrade(15);
        student.addGrade(15);
        student.addGrade(8);
        
        System.out.println("Moyenne des notes de " + student.name + " : " + student.getAverageGrade());
    }
}