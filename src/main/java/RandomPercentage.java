import java.util.Random;
import java.text.DecimalFormat;
public class RandomPercentage {
    public static void main(String[] args) {
        // TODO: Create two Random objects
        // 1. One Random object without a seed (unseeded)
        // 2. One Random object with any seed value (seeded)
        
        // TODO: Generate random double values from both Random objects
        // Use nextDouble() method to get values between 0.0 and 1.0
        
        // TODO: Format as percentages
        // Format the values to exactly 2 decimal places
        // Display with % symbol
        
        // TODO: Display the values as percentages
        // Show both unseeded and seeded random values
        // Each value should be formatted as below
        Random rand = new Random();
        Random rand1 = new Random(22);

        DecimalFormat df = new DecimalFormat("##0.00");

        System.out.printf("Unseeded Random: %s%%%nSeeded Random: %s%%",(df.format(rand.nextDouble() * 100)),df.format(rand1.nextDouble() * 100));
    }
}