import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double getCharge();
    public abstract String getType();
}

interface Insurable {
    double getInsurance(double declaredValue);
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double getCharge() {
        return 40.0 + (10.0 * weight);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double getCharge() {
        return 80.0 + (15.0 * weight);
    }

    @Override
    public double getInsurance(double value) {
        return value * 0.02;
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double getCharge() {
        return 40.0 + (10.0 * weight) + 50.0;
    }

    @Override
    public double getInsurance(double value) {
        return value * 0.02;
    }

    @Override
    public String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();

            if (type.equals("STANDARD")) {
                parcels.add(new StandardParcel(weight, value));
            } else if (type.equals("EXPRESS")) {
                parcels.add(new ExpressParcel(weight, value));
            } else if (type.equals("FRAGILE")) {
                parcels.add(new FragileParcel(weight, value));
            }
        }

        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            double charge = parcel.getCharge();
            double insurance = 0.0;
            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).getInsurance(parcel.declaredValue);
            }
            double total = charge + insurance;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", parcel.getType(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        scanner.close();
    }
}