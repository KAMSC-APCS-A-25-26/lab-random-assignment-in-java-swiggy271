[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/_X2bJkBB)
# Random Assignment

## Overview
This repository contains three assignments focused on using Java's `Random` class:
1. **RandomPercentage** - Generate random numbers and format them as percentages
2. **DiceRoller** - Create dice rolling simulation with multiple Random objects
3. **PhoneNumberGenerator** - Generate random phone numbers with specific constraints

## Learning Objectives
- Understand the difference between seeded and unseeded Random objects
- Generate random double values using `nextDouble()`
- Generate random integer values using `nextInt()`
- Format numbers to specific decimal places
- Convert values to percentages
- Simulate dice rolling with proper ranges
- Apply constraints to random number generation
- Format output with specific patterns

## Assignments

### Assignment 1: Random Percentage Generator

Create a Java program that:

1. **Create Two Random Objects:**
   - One `Random` object without a seed (unseeded)
   - One `Random` object with a a specific seed value

2. **Generate Random Values:**
   - Generate random double values from both Random objects
   - Use `nextDouble()` method to get values between 0.0 and 1.0

3. **Format as Percentages:**
   - Format the values to exactly 2 decimal places
   - Display with `%` symbol

4. **Output Format:**
   - Display both unseeded and seeded random values

## Example Output
```
Unseeded Random: 45.67%
Seeded Random: 23.45%
```

## Key Concepts

### Random Class
- `Random()` - Creates unseeded and seeded random number generator
- `nextDouble()` - Returns random double between 0.0 and 1.0

### Seeded vs Unseeded
- **Unseeded**: Produces different values each time program runs
- **Seeded**: Produces same sequence of values each time (deterministic)


### Assignment 2: Dice Roller

Create a Java program that simulates rolling dice:

1. **Create Four Random Objects:**
   - Three `Random` objects without seeds (unseeded dice)
   - One `Random` object with a seed of any value

2. **Generate Dice Rolls:**
   - Get values 1-6 (like a die)
   - Generate rolls from all four Random objects

3. **Display Results:**
   - Show all four dice rolls with clear labels
   - Demonstrate seeded vs unseeded behavior

## Example Output
```
Unseeded Die 1: 4
Unseeded Die 2: 2
Unseeded Die 3: 6
Seeded Die: 3
```

### Assignment 3: Phone Number Generator

Create a Java program that generates random phone numbers with specific constraints:

1. **Generate Phone Number Format:**
   - Display as XXX-XXX-XXX (include dashes)
   - Three groups of three digits each

2. **First Three Digits (Area Code):**
   - Cannot contain digits 8 or 9
   - Valid digits: 0, 1, 2, 3, 4, 5, 6, 7

3. **Second Three Digits (Exchange):**
   - Must be less than or equal to 742
   - Range: 000-742

4. **Third Three Digits (Subscriber):**
   - No constraints
   - Range: 000-999

## Example Output
```
123-456-789
```
