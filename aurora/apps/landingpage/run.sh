#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 [build|create|test|clean]"
    exit 1
fi

case $1 in
    build)
        echo "Running Gradle build..."
        ./gradlew build --refresh-dependencies
        ;;
    create)
        echo "Creates files..."
        current_timestamp=$(date +%s)
        sed -i "3s/.*/const val UniqueId = -${current_timestamp}/" src/nativeMain/kotlin/landingPage/UniqueId.kt
        ./gradlew build --refresh-dependencies
        ;;
    test)
        echo "Running Gradle tests..."
        ./gradlew detekt
        ./gradlew nativeTest
        ;;
    clean)
        echo "Cleaning Gradle build..."
        ./gradlew clean
        ;;
    *)
        echo "Invalid option: $1. Available options are build, create, test, and clean."
        exit 1
        ;;
esac
