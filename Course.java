import java.util.ArrayList;
import java.util.List;

public class Course  {

    private String CourseName;
    private int CreditHours;
    private Course courseCode;

    private static List<String> student = new ArrayList<>();

    public Course(int CreditHours, String student, String CourseName, Course courseCode) {
        this.CreditHours = CreditHours;
        this.CourseName = CourseName;
        this.courseCode = courseCode;
    }
    public static List<String> getStudent() {
        return student;
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
    public Course getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(Course courseCode) {
        this.courseCode = courseCode;
    }
    public void enrollStudent(String students) {
        student.add(students);
    }
    public static List<String> getEnrolledStudents() {
        return student;
    }
    public static void main(String[] args) {
    
        Course course = new Course(12, "name", "EXO", null);

        course.enrollStudent("Mathys");
        course.enrollStudent("Axel");
        course.enrollStudent("Vito");

        System.out.println("Tous les étudiants : " + getEnrolledStudents());
    }
}