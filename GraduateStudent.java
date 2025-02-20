public class GraduateStudent extends Student {
    
    public GraduateStudent(String name, int age, int studentID) {
    super(name, age, studentID);
    }
    @Override
    public double getAverageGrade() {
            return super.getAverageGrade() + 2;
    }
    public static void main(String[] args) {
        GraduateStudent gradStudent = new GraduateStudent("Charlie", 25, 2001);
        gradStudent.addGrade(12.8);
        gradStudent.addGrade(12.5);
        gradStudent.addGrade(18.7);

        System.out.println("Nom : " + gradStudent.getName());
        System.out.println("Moyenne (avec bonus) : " + gradStudent.getAverageGrade());
    }
}