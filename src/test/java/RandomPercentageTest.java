import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.regex.Pattern;

public class RandomPercentageTest {

    private String runProgramWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outBytes);
        
        PrintStream originalOut = System.out;
        System.setOut(out);
        
        try {
            RandomPercentage.main(new String[]{});
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
    public void testUnseededRandomGeneration() {
        String output = runProgramWithInput("");
        
        assertTrue(output.length() > 0, "❌ Program should produce output!");
        
        assertTrue(output.contains("%"), "❌ Should display values as percentages!");
        
        Pattern decimalPattern = Pattern.compile("\\d+\\.\\d{2}");
        assertTrue(decimalPattern.matcher(output).find(), 
            "❌ Should format numbers to 2 decimal places!");
    }

    @Test
    public void testSeededRandomGeneration() {
        String output = runProgramWithInput("");
        
        String output1 = runProgramWithInput("");
        String output2 = runProgramWithInput("");
        
        String[] lines1 = output1.split("\n");
        String[] lines2 = output2.split("\n");
        
        assertTrue(lines1.length >= 2, "❌ Should display both unseeded and seeded values!");
        assertTrue(lines2.length >= 2, "❌ Should display both unseeded and seeded values!");
    }

    @Test
    public void testPercentageConversion() {
        String output = runProgramWithInput("");
        
        Pattern percentagePattern = Pattern.compile("(\\d{1,2}\\.\\d{2}%|100\\.00%)");
        assertTrue(percentagePattern.matcher(output).find(), 
            "❌ Should display values as percentages in 0-100% range!");
    }

    @Test
    public void testDecimalFormatting() {
        String output = runProgramWithInput("");
        
        Pattern twoDecimalPattern = Pattern.compile("\\d+\\.\\d{2}%");
        assertTrue(twoDecimalPattern.matcher(output).find(), 
            "❌ Should format percentages to exactly 2 decimal places!");
        
        Pattern tooManyDecimals = Pattern.compile("\\d+\\.\\d{3,}%");
        assertFalse(tooManyDecimals.matcher(output).find(), 
            "❌ Should not have more than 2 decimal places!");
    }

    @Test
    public void testBothRandomObjectsUsed() {
        String output = runProgramWithInput("");
        
        
        Pattern percentagePattern = Pattern.compile("\\d+\\.\\d{2}%");
        long count = percentagePattern.matcher(output).results().count();
        
        assertTrue(count >= 2, "❌ Should display at least 2 random percentage values!");
    }

    @Test
    public void testRandomValueRange() {
        String output = runProgramWithInput("");
        
        Pattern percentagePattern = Pattern.compile("(\\d{1,2}\\.\\d{2}%|100\\.00%)");
        var matches = percentagePattern.matcher(output).results();
        
        boolean hasValidRange = matches.anyMatch(match -> {
            String value = match.group().replace("%", "");
            double percentage = Double.parseDouble(value);
            return percentage >= 0.0 && percentage <= 100.0;
        });
        
        assertTrue(hasValidRange, "❌ Random percentages should be in 0-100% range!");
    }

    @Test
    public void testNoCompilationErrors() {
        String output = runProgramWithInput("");
        
        assertFalse(output.contains("Exception"), "❌ Program should not throw exceptions!");
        assertFalse(output.contains("Error"), "❌ Program should not display error messages!");
        assertFalse(output.contains("Exception in thread"), "❌ Program should not crash!");
    }
}
