class StudentResult {
    String name;
    int[] marks;

    public StudentResult(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        double sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public String determineGrade(double average) {
        if (average >= 75) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}

public class ResultCardGenerator {
    public static void main(String[] args) {
        StudentResult s1 = new StudentResult("Asha", new int[]{80, 90, 70});
        double avg = s1.calculateAverage();
        String grade = s1.determineGrade(avg);

        System.out.printf("%s: Average %.1f, Grade %s\n", s1.name.toUpperCase(), avg, grade);
    }
}