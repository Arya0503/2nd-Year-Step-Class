import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Connection {
    protected int units;
    protected String type;

    public Connection(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public abstract double calculateBill();

    public String getType() {
        return type;
    }
}

class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        double bill = units * 6.0;
        return Math.max(bill, 1000.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            if (type.equals("HOME")) {
                connections.add(new HomeConnection(units));
            } else if (type.equals("SHOP")) {
                connections.add(new ShopConnection(units));
            } else if (type.equals("FACTORY")) {
                connections.add(new FactoryConnection(units));
            }
        }

        double total = 0.0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            System.out.printf("%s: %.2f\n", c.getType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}