import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class TicketBooking {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public TicketBooking(int count) {
        this.count = count;
    }

    protected abstract double getSeatPrice();
    public abstract String getType();

    public double getAmount() {
        return (getSeatPrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularBooking extends TicketBooking {
    public RegularBooking(int count) {
        super(count);
    }

    @Override
    protected double getSeatPrice() {
        return 150.0;
    }

    @Override
    public String getType() {
        return "REGULAR";
    }
}

class PremiumBooking extends TicketBooking {
    public PremiumBooking(int count) {
        super(count);
    }

    @Override
    protected double getSeatPrice() {
        return 250.0;
    }

    @Override
    public String getType() {
        return "PREMIUM";
    }
}

class ReclinerBooking extends TicketBooking {
    public ReclinerBooking(int count) {
        super(count);
    }

    @Override
    protected double getSeatPrice() {
        return 400.0;
    }

    @Override
    public String getType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<TicketBooking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();

            if (type.equals("REGULAR")) {
                bookings.add(new RegularBooking(count));
            } else if (type.equals("PREMIUM")) {
                bookings.add(new PremiumBooking(count));
            } else if (type.equals("RECLINER")) {
                bookings.add(new ReclinerBooking(count));
            }
        }

        double total = 0.0;
        for (TicketBooking booking : bookings) {
            double amount = booking.getAmount();
            System.out.printf("%s: %.2f\n", booking.getType(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}