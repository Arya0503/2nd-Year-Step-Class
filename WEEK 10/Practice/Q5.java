public class DigitSumAndReversal {
    public static void main(String[] args) {
        int number = 4721;
        int sum = 0;
        int reversed = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            reversed = (reversed * 10) + digit;
            number /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }
}