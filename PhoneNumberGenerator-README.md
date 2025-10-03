# PhoneNumberGenerator Assignment

## Overview
This assignment focuses on generating random phone numbers with specific constraints using Java's `Random` class and conditional logic.

## Learning Objectives
- Generate random integers with specific constraints
- Apply conditional logic to random number generation
- Format output with specific patterns (XXX-XXX-XXX)
- Understand range limitations and validation
- Practice with multiple random number generations

## Assignment Requirements

### Task: Random Phone Number Generator

Create a Java program that generates random phone numbers following specific constraints.

### Requirements:

1. **Generate Phone Number Format:**
   - Display as XXX-XXX-XXX (include dashes)
   - Three groups of three digits each

2. **First Three Digits (Area Code):**
   - Cannot contain digits 8 or 9
   - Valid digits: 0, 1, 2, 3, 4, 5, 6, 7
   - Range: 000-777 (but no 8 or 9)

3. **Second Three Digits (Exchange):**
   - Must be less than or equal to 742
   - Range: 000-742

4. **Third Three Digits (Subscriber):**
   - No constraints
   - Range: 000-999

5. **Output Format:**
   - Include dashes in the display
   - Format: XXX-XXX-XXX

## Example Output
```
123-456-789
```


## Test Cases

The autograder tests the following:

1. **Program Compilation**: Code compiles without errors
2. **Phone Number Format**: Displays XXX-XXX-XXX format with dashes
3. **First Digits Constraint**: First three digits don't contain 8 or 9
4. **Second Digits Constraint**: Second three digits are <= 742
5. **Third Digits Range**: Third three digits are valid (000-999)
6. **Random Generation**: Produces different phone numbers
7. **All Constraints**: All constraints met in single phone number
8. **No Errors**: Program runs without exceptions


## Grading Criteria
- Program compiles without errors
- Generates phone number in XXX-XXX-XXX format
- First three digits don't contain 8 or 9
- Second three digits are <= 742
- Third three digits are valid (000-999)
- Includes dashes in output
- Uses Random class for generation


- Remember to include dashes in the output format
- Test your constraints by running the program multiple times
