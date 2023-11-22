#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 [build|create|test|clean]"
    exit 1
fi

case $1 in
    build)
        echo "Running Gradle build..."
        set -x #echo on
        ( cd libs && ./run.sh build)
        ( cd modules && ./run.sh build)
        ( cd apps && ./run.sh build)
        ;;
    create)
        echo "Creates files..."
        set -x #echo on
        ( cd libs && ./run.sh create)
        ( cd modules && ./run.sh create)
        ( cd apps && ./run.sh create)
        ;;
    test)
        echo "Running Gradle tests..."
        set -x #echo on
        ( cd libs && ./run.sh test)
        ( cd modules && ./run.sh test)
        ( cd apps && ./run.sh test)
        ;;
    clean)
        echo "Cleaning Gradle build..."
        set -x #echo on
        ( cd libs && ./run.sh clean)
        ( cd modules && ./run.sh clean)
        ( cd apps && ./run.sh clean)
        ;;
    *)
        echo "Invalid option: $1. Available options are build, create, test, and clean."
        exit 1
        ;;
esac
