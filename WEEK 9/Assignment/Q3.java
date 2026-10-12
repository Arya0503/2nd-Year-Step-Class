import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double getTuition();
    public String getName() {
        return name;
    }
}

interface BusUser {
    double getTransportFee();
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double getTuition() {
        return 40000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double getTuition() {
        return 40000.0 + 60000.0;
    }
}

class Scholar extends Student implements BusUser {
    public Scholar(String name) {
        super(name);
    }

    @Override
    public double getTuition() {
        return 20000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            if (type.equals("DAY_SCHOLAR")) {
                students.add(new DayScholar(scanner.next()));
            } else if (type.equals("HOSTELLER")) {
                students.add(new Hosteller(scanner.next()));
            } else if (type.equals("SCHOLAR")) {
                students.add(new Scholar(scanner.next()));
            }
        }

        double totalCollected = 0.0;
        for (Student student : students) {
            double fee = student.getTuition();
            if (student instanceof BusUser) {
                fee += ((BusUser) student).getTransportFee();
            }
            System.out.printf("%s: %.2f\n", student.getName(), fee);
            totalCollected += fee;
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}