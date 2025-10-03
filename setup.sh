#!/bin/bash

echo "🔧 Setting up Random Assignment environment..."

# Make sure we're in the right directory
cd "$(dirname "$0")"

# Compile the project
echo "📦 Compiling Java project..."
mvn -q clean compile

if [ $? -eq 0 ]; then
    echo "✅ Setup complete! Ready to work on Random assignments."
else
    echo "❌ Setup failed. Check your Java installation and Maven configuration."
    exit 1
fi
