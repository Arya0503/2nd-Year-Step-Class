import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
    public abstract String getType();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.00 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.00 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.00 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            if (type.equals("STANDARD")) {
                deliveries.add(new StandardDelivery(scanner.nextDouble(), scanner.nextDouble()));
            } else if (type.equals("EXPRESS")) {
                deliveries.add(new ExpressDelivery(scanner.nextDouble(), scanner.nextDouble()));
            } else if (type.equals("INTERNATIONAL")) {
                deliveries.add(new InternationalDelivery(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()));
            }
        }

        double total = 0.0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            System.out.printf("%s: %.2f\n", d.getType(), fee);
            total += fee;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}