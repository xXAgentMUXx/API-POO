public class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Course course, Student student) {
        this.student = student;
        this.course = course;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public void register() {
        course.enrollStudent(student);
    }
    public static void main(String[] args) {
        Course mathCourse = new Course("Mathématiques", "MATH101", 3);
        Student student1 = new Student("Alice", 22, 1001);

        Enrollment enrollment = new Enrollment(mathCourse, student1);
        enrollment.register();

        System.out.println("Etudiant inscrit : " + enrollment.getStudent().getName());
        System.out.println("Liste des etudiants en cours " + mathCourse.getCourseName() + " :");
        for (Student s : mathCourse.getEnrolledStudents()) {
            System.out.println("- " + s.getName());
        }
    }
}