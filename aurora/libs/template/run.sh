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
        ./gradlew publishToMavenLocal
        ;;
    test)
        echo "Running Gradle tests..."
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
