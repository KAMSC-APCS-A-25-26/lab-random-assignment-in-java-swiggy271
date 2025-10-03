#!/bin/bash

echo "🎲 Running Dice Roller Tests..."

# Run only DiceRoller tests
mvn -B test -Dtest=DiceRollerTest

if [ $? -eq 0 ]; then
    echo ""
    echo "🎉 Dice Roller tests passed! Great work!"
else
    echo ""
    echo "❌ Some Dice Roller tests failed. Check the output above for details."
    echo "💡 Remember to:"
    echo "   - Create three unseeded Random objects"
    echo "   - Create one seeded Random object"
    echo "   - Use nextInt(6) + 1 for dice rolls (1-6)"
    echo "   - Display all four dice rolls with clear labels"
fi
