import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    protected abstract double getPowerRating();
    public abstract String getType();

    public double getUnits() {
        return (getPowerRating() * hours) / 1000.0;
    }
}

interface SaverMode {
    double applySaver(double units);
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerRating() {
        return 150.0;
    }

    @Override
    public String getType() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerRating() {
        return 1500.0;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

class TV extends Appliance {
    public TV(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerRating() {
        return 100.0;
    }

    @Override
    public String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {
    public Washer(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerRating() {
        return 500.0;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }

    @Override
    public String getType() {
        return "WASHER";
    }
}

class ApplianceRequest {
    Appliance appliance;
    boolean isSaverRequested;

    public ApplianceRequest(Appliance appliance, boolean isSaverRequested) {
        this.appliance = appliance;
        this.isSaverRequested = isSaverRequested;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<ApplianceRequest> requests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split(" ");

            String type = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean isSaver = tokens.length == 3 && tokens[2].equals("SAVER");

            if (type.equals("FRIDGE")) {
                requests.add(new ApplianceRequest(new Fridge(hours), isSaver));
            } else if (type.equals("AC")) {
                requests.add(new ApplianceRequest(new AirConditioner(hours), isSaver));
            } else if (type.equals("TV")) {
                requests.add(new ApplianceRequest(new TV(hours), isSaver));
            } else if (type.equals("WASHER")) {
                requests.add(new ApplianceRequest(new Washer(hours), isSaver));
            }
        }

        double totalCost = 0.0;
        for (ApplianceRequest req : requests) {
            if (req.isSaverRequested && !(req.appliance instanceof SaverMode)) {
                System.out.printf("%s: saver mode not supported\n", req.appliance.getType());
                continue;
            }

            double units = req.appliance.getUnits();
            if (req.isSaverRequested) {
                units = ((SaverMode) req.appliance).applySaver(units);
            }

            double cost = units * 8.0;
            System.out.printf("%s: Units=%.2f Cost=%.2f\n", req.appliance.getType(), units, cost);
            totalCost += cost;
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}