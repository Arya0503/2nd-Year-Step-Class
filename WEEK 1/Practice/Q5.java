public class CustomerIdentityVerification {
    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversedName = reverseCustomerName(customerName);

        System.out.println("Input\n\"" + customerName + "\"");
        System.out.println("Output");
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }

    public static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder();

        for (int i = characters.length - 1; i >= 0; i--) {
            reversed.append(characters[i]);
        }

        return reversed.toString();
    }
}