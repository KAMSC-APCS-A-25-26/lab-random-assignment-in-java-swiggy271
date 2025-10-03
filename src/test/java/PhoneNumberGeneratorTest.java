import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.regex.Pattern;

public class PhoneNumberGeneratorTest {

    private String runProgramWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outBytes);
        
        PrintStream originalOut = System.out;
        System.setOut(out);
        
        try {
            PhoneNumberGenerator.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }
        
        return outBytes.toString(StandardCharsets.UTF_8);
    }

    @Test
    public void testProgramCompiles() {
        String output = runProgramWithInput("");
        assertNotNull(output, "❌ Program should produce output!");
    }

    @Test
    public void testPhoneNumberFormat() {
        String output = runProgramWithInput("");
        
        Pattern phonePattern = Pattern.compile("\\d{3}-\\d{3}-\\d{3}");
        assertTrue(phonePattern.matcher(output).find(), 
            "❌ Should display phone number in XXX-XXX-XXX format!");
    }

    @Test
    public void testFirstThreeDigitsConstraint() {
        String output = runProgramWithInput("");
        
        Pattern phonePattern = Pattern.compile("(\\d{3})-\\d{3}-\\d{3}");
        var matches = phonePattern.matcher(output).results();
        
        boolean hasValidFirstDigits = matches.allMatch(match -> {
            String firstThree = match.group(1);
            return !firstThree.contains("8") && !firstThree.contains("9");
        });
        
        assertTrue(hasValidFirstDigits, 
            "❌ First three digits should not contain 8 or 9!");
    }

    @Test
    public void testSecondThreeDigitsConstraint() {
        String output = runProgramWithInput("");
        
        Pattern phonePattern = Pattern.compile("\\d{3}-(\\d{3})-\\d{3}");
        var matches = phonePattern.matcher(output).results();
        
        boolean hasValidSecondDigits = matches.allMatch(match -> {
            int secondThree = Integer.parseInt(match.group(1));
            return secondThree <= 742;
        });
        
        assertTrue(hasValidSecondDigits, 
            "❌ Second three digits should be <= 742!");
    }

    @Test
    public void testThirdThreeDigitsNoConstraint() {
        String output = runProgramWithInput("");
        
        Pattern phonePattern = Pattern.compile("\\d{3}-\\d{3}-(\\d{3})");
        var matches = phonePattern.matcher(output).results();
        
        boolean hasValidThirdDigits = matches.allMatch(match -> {
            int thirdThree = Integer.parseInt(match.group(1));
            return thirdThree >= 0 && thirdThree <= 999;
        });
        
        assertTrue(hasValidThirdDigits, 
            "❌ Third three digits should be valid (000-999)!");
    }

    @Test
    public void testRandomGeneration() {
        String output1 = runProgramWithInput("");
        String output2 = runProgramWithInput("");
        
        Pattern phonePattern = Pattern.compile("\\d{3}-\\d{3}-\\d{3}");
        var matches1 = phonePattern.matcher(output1).results().map(m -> m.group()).toArray();
        var matches2 = phonePattern.matcher(output2).results().map(m -> m.group()).toArray();
        
        assertTrue(matches1.length > 0, "❌ Should generate phone numbers!");
        assertTrue(matches2.length > 0, "❌ Should generate phone numbers!");
        
        boolean hasVariation = false;
        for (int i = 0; i < Math.min(matches1.length, matches2.length); i++) {
            if (!matches1[i].equals(matches2[i])) {
                hasVariation = true;
                break;
            }
        }
        
        assertTrue(hasVariation, "❌ Should generate different phone numbers!");
    }

    @Test
    public void testAllConstraintsTogether() {
        String output = runProgramWithInput("");
        
        Pattern phonePattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{3})");
        var matches = phonePattern.matcher(output).results();
        
        boolean allConstraintsMet = matches.allMatch(match -> {
            String firstThree = match.group(1);
            int secondThree = Integer.parseInt(match.group(2));
            int thirdThree = Integer.parseInt(match.group(3));
            
            return !firstThree.contains("8") && !firstThree.contains("9") &&  // First constraint
                   secondThree <= 742 &&                                      // Second constraint
                   thirdThree >= 0 && thirdThree <= 999;                     // Third constraint
        });
        
        assertTrue(allConstraintsMet, 
            "❌ All phone number constraints should be met!");
    }

    @Test
    public void testNoCompilationErrors() {
        String output = runProgramWithInput("");
        
        assertFalse(output.contains("Exception"), "❌ Program should not throw exceptions!");
        assertFalse(output.contains("Error"), "❌ Program should not display error messages!");
        assertFalse(output.contains("Exception in thread"), "❌ Program should not crash!");
    }
}
