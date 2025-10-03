#!/bin/bash

echo "📞 Running Phone Number Generator Tests..."

# Run only PhoneNumberGenerator tests
mvn -B test -Dtest=PhoneNumberGeneratorTest

if [ $? -eq 0 ]; then
    echo ""
    echo "🎉 Phone Number Generator tests passed! Great work!"
else
    echo ""
    echo "❌ Some Phone Number Generator tests failed. Check the output above for details."
    echo "💡 Remember to:"
    echo "   - Generate phone number in XXX-XXX-XXX format"
    echo "   - First three digits cannot contain 8 or 9"
    echo "   - Second three digits must be <= 742"
    echo "   - Third three digits can be 000-999"
    echo "   - Include dashes in the output"
fi
