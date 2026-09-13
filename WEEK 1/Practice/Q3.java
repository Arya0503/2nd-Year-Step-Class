import java.util.Random;

public class BmiCalculator {
    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        Random random = new Random();

        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.5 + (random.nextDouble() * 0.5); // Random height between 1.5m and 2.0m
            weights[i] = 50 + (random.nextDouble() * 60);   // Random weight between 50kg and 110kg
        }

        printWellnessReport(heights, weights);
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-2d | %-10.2f | %-11.2f | %-5.2f | %s\n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }
}