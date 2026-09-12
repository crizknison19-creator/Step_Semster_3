import java.util.Random;

public class TeamBmiCalculator {

    private static final int TEAM_SIZE = 10;


    public static double calculateBmi(double heightInMeters, double weightInKg) {
        if (heightInMeters <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return weightInKg / (heightInMeters * heightInMeters);
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Generates random, realistic height and weight values for a fast live demo.
     */
    public static double[] generateRandomHeights(int teamSize) {
        Random random = new Random();
        double[] heights = new double[teamSize];
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + random.nextDouble() * 0.45; // 1.50m to 1.95m
        }
        return heights;
    }

    public static double[] generateRandomWeights(int teamSize) {
        Random random = new Random();
        double[] weights = new double[teamSize];
        for (int i = 0; i < teamSize; i++) {
            weights[i] = 50 + random.nextDouble() * 60; // 50kg to 110kg
        }
        return weights;
    }


    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights arrays must be the same length.");
        }

        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBmi(heights[i], weights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-6d | %-10.2f | %-11.2f | %-5.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        try {
            double[] teamHeights = generateRandomHeights(TEAM_SIZE);
            double[] teamWeights = generateRandomWeights(TEAM_SIZE);

            printWellnessReport(teamHeights, teamWeights);

        } catch (IllegalArgumentException e) {
            System.out.println("Error generating wellness report: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}