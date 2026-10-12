import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Cab {
    protected double distance;

    public Cab(double distance) {
        this.distance = distance;
    }

    protected abstract double getRate();
    public abstract String getType();

    public double getBaseFare() {
        return Math.max(100.0, distance * getRate());
    }
}

interface NightServiceable {
    double applyNightCharge(double baseFare);
}

class MiniCab extends Cab {
    public MiniCab(double distance) {
        super(distance);
    }

    @Override
    protected double getRate() {
        return 10.0;
    }

    @Override
    public String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double distance) {
        super(distance);
    }

    @Override
    protected double getRate() {
        return 14.0;
    }

    @Override
    public double applyNightCharge(double baseFare) {
        return baseFare * 1.20;
    }

    @Override
    public String getType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double distance) {
        super(distance);
    }

    @Override
    protected double getRate() {
        return 18.0;
    }

    @Override
    public double applyNightCharge(double baseFare) {
        return baseFare * 1.20;
    }

    @Override
    public String getType() {
        return "SUV";
    }
}

class TripRequest {
    Cab cab;
    String time;

    public TripRequest(Cab cab, String time) {
        this.cab = cab;
        this.time = time;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<TripRequest> requests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            if (type.equals("MINI")) {
                requests.add(new TripRequest(new MiniCab(km), time));
            } else if (type.equals("SEDAN")) {
                requests.add(new TripRequest(new SedanCab(km), time));
            } else if (type.equals("SUV")) {
                requests.add(new TripRequest(new SUVCab(km), time));
            }
        }

        double total = 0.0;
        for (TripRequest req : requests) {
            if (req.time.equals("NIGHT") && !(req.cab instanceof NightServiceable)) {
                System.out.printf("%s: night service not available\n", req.cab.getType());
                continue;
            }

            double fare = req.cab.getBaseFare();
            if (req.time.equals("NIGHT")) {
                fare = ((NightServiceable) req.cab).applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f\n", req.cab.getType(), fare);
            total += fare;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}