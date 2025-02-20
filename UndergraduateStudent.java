public class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name, int age, int studentID) {
        super(name, age, studentID);
    }
    @Override
    public double getAverageGrade() {
    return super.getAverageGrade() - 2;
    }
    public static void main(String[] args) {
        UndergraduateStudent gradStudent = new UndergraduateStudent("Charlie", 25, 2001);
        gradStudent.addGrade(10.9);
        gradStudent.addGrade(12.8);
        gradStudent.addGrade(14.7);

        System.out.println("Nom : " + gradStudent.getName());
        System.out.println("Moyenne (avec bonus) : " + gradStudent.getAverageGrade());
    }
}