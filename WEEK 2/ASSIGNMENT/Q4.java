public class LibraryISBNValidator {

    public static String normalizeCode(String raw) {
        // Trim leading and trailing spaces[cite: 1]
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed; // Failsafe for severely malformed input
        }

        // Uppercase only the first 3 characters using substring() + concatenation[cite: 1]
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);

        return firstThree + remainder;
    }

    public static String validateAndFormat(String code) {
        // Validate exactly 13 characters after normalization[cite: 1]
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Validate the first 3 characters are letters[cite: 1]
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate the remaining 10 characters are digits[cite: 1]
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Build a formatted display line with StringBuilder[cite: 1]
        StringBuilder formatted = new StringBuilder();
        formatted.append("[")
                .append(code.substring(0, 3))
                .append("] YEAR: ")
                .append(code.substring(3, 7))
                .append(" | CATALOG: ")
                .append(code.substring(7));

        return formatted.toString();
    }

    public static void main(String[] args) {
        String code1 = normalizeCode("   pen2026004251 ");
        System.out.println(validateAndFormat(code1)); // Expected: [PEN] YEAR: 2026 | CATALOG: 004251

        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2)); // Expected: Invalid: publisher code must be 3 letters
    }
}