#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 [build|create|test|clean]"
    exit 1
fi

case $1 in
    build)
        echo "Running Gradle build..."
        set -x #echo on
        ( cd frontend && ./run.sh build)
        ;;
    create)
        echo "Creates files..."
        set -x #echo on
        ( cd frontend && ./run.sh create)
        ;;
    test)
        echo "Running Gradle tests..."
        set -x #echo on
        ( cd frontend && ./run.sh test)
        ;;
    clean)
        echo "Cleaning Gradle build..."
        set -x #echo on
        ( cd frontend && ./run.sh clean)
        ;;
    *)
        echo "Invalid option: $1. Available options are build, create, test, and clean."
        exit 1
        ;;
esac
