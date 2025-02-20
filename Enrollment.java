
public class Enrollment {
    private String student;
    private Course course;

    public Enrollment(Course course, String student) {
        this.student = student;
        this.course = course;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public String getStudent() {
        return student;
    }
    public void setStudent(String student) {
        this.student = student;
    }
    public void register() {
        
    }
}