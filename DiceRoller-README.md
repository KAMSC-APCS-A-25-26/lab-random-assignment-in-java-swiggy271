# DiceRoller Assignment

## Overview
This assignment focuses on using Java's `Random` class to simulate rolling dice, demonstrating the difference between seeded and unseeded random number generation.

## Learning Objectives
- Create multiple Random objects (seeded and unseeded)
- Generate random integers using `nextInt()`
- Understand dice rolling simulation (1-6 range)
- Demonstrate seeded vs unseeded behavior
- Practice with multiple Random objects in one program

## Assignment Requirements

### Task: Dice Rolling Simulation

Create a Java program that simulates rolling four dice with different random number generators.

### Requirements:

1. **Create Four Random Objects:**
   - Three `Random` objects without seeds (unseeded dice)
   - One `Random` object with a seed of any value (seeded die)

2. **Generate Dice Rolls:**
   - Generate rolls from all four Random objects
   - Remember one of the four should be seeded!

3. **Display Results:**
   - Show all four dice rolls with clear labels
   - Demonstrate seeded vs unseeded behavior

4. **Output Format:**
   - Display all four dice rolls
   - Use clear labels to distinguish between dice

## Example Output
```
Unseeded Die 1: 4
Unseeded Die 2: 2
Unseeded Die 3: 6
Seeded Die: 3
```

## Key Concepts

### Random Class Methods
- `Random()` - Creates unseeded/seeded random number generator
- `nextInt()` - Returns random integer 



### Seeded vs Unseeded Behavior
- **Unseeded Dice**: Produce different values each time program runs
- **Seeded Die**: Produces same sequence of values each time (deterministic)


## Tips
- The seeded die will always produce the same values for the same seed
- Unseeded dice will produce different values each time you run the program
- You can use any seed value for the seeded die 
- Run the program multiple times to see the difference between seeded and unseeded behavior
