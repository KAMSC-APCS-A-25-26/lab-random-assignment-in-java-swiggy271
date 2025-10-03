import java.util.Random;
import java.text.DecimalFormat;
public class PhoneNumberGenerator {
    public static void main(String[] args) {
        // TODO: Create Random object for phone number generation
        
        // TODO: Generate first three digits (XXX)
        // Constraint: Cannot contain 8 or 9 (digits 0-7 only)
        
        // TODO: Generate second three digits (XXX) 
        // Constraint: Must be <= 742 (000-742)
        
        // TODO: Generate third three digits (XXX)
        // No constraints (000-999)
        
        // TODO: Format and display phone number as XXX-XXX-XXX
        // Include the dashes in the output
        DecimalFormat df = new DecimalFormat("000");
        Random rand = new Random();
        int first1, first2, first3, second, third;
        first1 = rand.nextInt(8);
        first2 = rand.nextInt(8);
        first3 = rand.nextInt(8);

        second = rand.nextInt(742);

        third = rand.nextInt(1000);

        System.out.printf("%d%d%d-%s-%s",first1,first2,first3,df.format(second),df.format(third));
    }
}
