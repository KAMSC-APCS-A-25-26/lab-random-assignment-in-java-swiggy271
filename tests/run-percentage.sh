#!/bin/bash

echo "🧪 Running Random Percentage Tests..."

# Run only RandomPercentage tests
mvn -B test -Dtest=RandomPercentageTest

if [ $? -eq 0 ]; then
    echo ""
    echo "🎉 Random Percentage tests passed! Great work!"
else
    echo ""
    echo "❌ Some Random Percentage tests failed. Check the output above for details."
    echo "💡 Remember to:"
    echo "   - Create both unseeded and seeded Random objects"
    echo "   - Generate random double values"
    echo "   - Format to 2 decimal places"
    echo "   - Display as percentages (multiply by 100)"
fi
