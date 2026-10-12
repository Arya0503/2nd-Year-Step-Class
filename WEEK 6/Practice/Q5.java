class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentCollegeInfoManagement {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 85);
        Student student2 = new Student("Bob", 92);

        Student.printCollegeInfo();
    }
}