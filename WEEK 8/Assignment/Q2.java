import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
    public abstract String getType();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return 10.0 * hours;
    }

    @Override
    public String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        } else {
            return 30.0 + (20.0 * (hours - 1));
        }
    }

    @Override
    public String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        double charge = 50.0 * hours;
        return Math.max(charge, 100.0);
    }

    @Override
    public String getType() {
        return "TRUCK";
    }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            if (type.equals("BIKE")) {
                vehicles.add(new Bike(hours));
            } else if (type.equals("CAR")) {
                vehicles.add(new Car(hours));
            } else if (type.equals("TRUCK")) {
                vehicles.add(new Truck(hours));
            }
        }

        double total = 0.0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f\n", v.getType(), charge);
            total += charge;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}