public class ATMPinValidator {

    public static void checkPinLength(String pin) {
        // Get the length of the string using length()
        if (pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN must be exactly 4 digits.");
        }
    }

    public static void main(String[] args) {
        checkPinLength("482");  // Expected: Invalid PIN must be exactly 4 digits.
        checkPinLength("4820"); // Expected: PIN length OK.
    }
}