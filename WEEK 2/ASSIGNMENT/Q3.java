public class InventoryCSVParser {

    public static void parseInventoryRecord(String csvLine) {
        // Break the line into fields using split(",")[cite: 1]
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present[cite: 1]
        if (fields.length == 3) {
            String product = fields[0].trim();
            String sku = fields[1].trim();
            String qty = fields[2].trim();

            // Print a formatted record[cite: 1]
            System.out.println("Product: " + product + " | SKU: " + sku + " | Qty: " + qty);
        } else {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse, WM-2201,150");
        parseInventoryRecord("Wireless Mouse, 150");
    }
}