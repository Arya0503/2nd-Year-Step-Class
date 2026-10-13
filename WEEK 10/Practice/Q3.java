public class EvenOddCounter {
    public static void main(String[] args) {
        int[] numbers = {3, 8, 12, 5, 7, 10};
        int evens = 0;
        int odds = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }

        System.out.println("Even: " + evens);
        System.out.println("Odd: " + odds);
    }
}