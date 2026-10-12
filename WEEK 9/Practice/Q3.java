import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();

    public String getTitle() {
        return title;
    }
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return 2.0 * daysLate;
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = 5.0 * daysLate;
        return Math.min(fine, 50.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return 1.0 * daysLate;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            if (type.equals("BOOK")) {
                items.add(new BookItem(title, daysLate));
            } else if (type.equals("DVD")) {
                items.add(new DVDItem(title, daysLate));
            } else if (type.equals("MAGAZINE")) {
                items.add(new MagazineItem(title, daysLate));
            }
        }

        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f\n", item.getTitle(), fine);
            totalFines += fine;
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
        scanner.close();
    }
}