import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class TravelBooking {
    protected double distance;
    protected String mode;
    protected static final double BOOKING_FEE = 50.0;

    public TravelBooking(String mode, double distance) {
        this.mode = mode;
        this.distance = distance;
    }

    protected abstract double getBaseFare();

    public double getTotalFare() {
        return getBaseFare() + BOOKING_FEE;
    }

    public String getMode() {
        return mode;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distance) {
        super("BUS", distance);
    }

    @Override
    protected double getBaseFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distance) {
        super("TRAIN", distance);
    }

    @Override
    protected double getBaseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distance) {
        super("FLIGHT", distance);
    }

    @Override
    protected double getBaseFare() {
        return 2500.0 + (distance * 4.0);
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<TravelBooking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();

            if (mode.equals("BUS")) {
                bookings.add(new BusBooking(distance));
            } else if (mode.equals("TRAIN")) {
                bookings.add(new TrainBooking(distance));
            } else if (mode.equals("FLIGHT")) {
                bookings.add(new FlightBooking(distance));
            }
        }

        for (TravelBooking b : bookings) {
            System.out.printf("%s: %.2f\n", b.getMode(), b.getTotalFare());
        }
        scanner.close();
    }
}