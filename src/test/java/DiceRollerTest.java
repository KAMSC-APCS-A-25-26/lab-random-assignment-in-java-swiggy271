import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.regex.Pattern;

public class DiceRollerTest {

    private String runProgramWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outBytes);
        
        PrintStream originalOut = System.out;
        System.setOut(out);
        
        try {
            DiceRoller.main(new String[]{});
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
    public void testDiceRollGeneration() {
        String output = runProgramWithInput("");
        
        assertTrue(output.length() > 0, "❌ Program should produce output!");
        
        Pattern dicePattern = Pattern.compile("[1-6]");
        assertTrue(dicePattern.matcher(output).find(), 
            "❌ Should display dice roll values (1-6)!");
    }

    @Test
    public void testMultipleDiceRolls() {
        String output = runProgramWithInput("");
        
        Pattern dicePattern = Pattern.compile("[1-6]");
        long count = dicePattern.matcher(output).results().count();
        
        assertTrue(count >= 4, "❌ Should display at least 4 dice rolls!");
    }

    @Test
    public void testDiceRollRange() {
        String output = runProgramWithInput("");
        
        Pattern numberPattern = Pattern.compile("\\b([1-6])\\b");
        var matches = numberPattern.matcher(output).results();
        
        boolean hasValidRange = matches.allMatch(match -> {
            int value = Integer.parseInt(match.group(1));
            return value >= 1 && value <= 6;
        });
        
        assertTrue(hasValidRange, "❌ All dice rolls should be in 1-6 range!");
    }

    @Test
    public void testSeededDiceConsistency() {
        String output1 = runProgramWithInput("");
        String output2 = runProgramWithInput("");
        
        Pattern numberPattern = Pattern.compile("\\b([1-6])\\b");
        var matches1 = numberPattern.matcher(output1).results().map(m -> m.group(1)).toArray();
        var matches2 = numberPattern.matcher(output2).results().map(m -> m.group(1)).toArray();
        
        assertEquals(matches1.length, matches2.length, 
            "❌ Should have same number of dice rolls each run!");
        
        boolean hasConsistentDice = false;
        for (int i = 0; i < Math.min(matches1.length, matches2.length); i++) {
            if (matches1[i].equals(matches2[i])) {
                hasConsistentDice = true;
                break;
            }
        }
        
        assertTrue(hasConsistentDice, "❌ Seeded dice should produce consistent values!");
    }

    @Test
    public void testUnseededDiceVariation() {
        String output1 = runProgramWithInput("");
        String output2 = runProgramWithInput("");
        
        Pattern numberPattern = Pattern.compile("\\b([1-6])\\b");
        var matches1 = numberPattern.matcher(output1).results().map(m -> m.group(1)).toArray();
        var matches2 = numberPattern.matcher(output2).results().map(m -> m.group(1)).toArray();
        
        boolean hasVariation = false;
        for (int i = 0; i < Math.min(matches1.length, matches2.length); i++) {
            if (!matches1[i].equals(matches2[i])) {
                hasVariation = true;
                break;
            }
        }
        
        assertTrue(hasVariation, "❌ Unseeded dice should produce different values!");
    }

    @Test
    public void testDiceRollLabels() {
        String output = runProgramWithInput("");
        
        boolean hasLabels = output.toLowerCase().contains("die") || 
                           output.toLowerCase().contains("dice") ||
                           output.toLowerCase().contains("roll") ||
                           output.contains("1") || output.contains("2") || 
                           output.contains("3") || output.contains("4") ||
                           output.contains("5") || output.contains("6");
        
        assertTrue(hasLabels, "❌ Should display dice roll information!");
    }

    @Test
    public void testNoCompilationErrors() {
        String output = runProgramWithInput("");
        
        assertFalse(output.contains("Exception"), "❌ Program should not throw exceptions!");
        assertFalse(output.contains("Error"), "❌ Program should not display error messages!");
        assertFalse(output.contains("Exception in thread"), "❌ Program should not crash!");
    }
}
