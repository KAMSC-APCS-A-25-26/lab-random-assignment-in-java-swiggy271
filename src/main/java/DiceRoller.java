import java.util.Random;

public class DiceRoller {
    public static void main(String[] args) {
        // TODO: Create Random objects for dice rolling
        // 1. Three Random objects without seeds (unseeded dice)
        // 2. One Random object with any seed value (seeded die)
        
        // TODO: Generate random integers for dice rolls
        
        // TODO: Display the dice rolls - 1-6
        // Show all four dice rolls with clear labels
        
        // TODO: Demonstrate the difference between seeded and unseeded
        // Run the program multiple times to show seeded consistency

        Random rand1 = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random();
        Random rand4 = new Random(67);
        System.out.println("Unseeded die 1: " + (rand1.nextInt(6) + 1) + "\nUnseeded die 2: " + (rand2.nextInt(6) + 1) + "\nUnseeded die 3: " + (rand3.nextInt(6) + 1) + "\nSeeded die 1: " + (rand4.nextInt(6) + 1));
    }
}
