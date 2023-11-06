#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 [build|publish|test|clean]"
    exit 1
fi

case $1 in
    build)
        echo "Running Gradle build..."
        set -x #echo on
        ( cd libs && ./run.sh build)
        ( cd modules && ./run.sh build)
        ;;
    publish)
        echo "Publish to Local Repository..."
        set -x #echo on
        ( cd libs && ./run.sh publish)
        ( cd modules && ./run.sh publish)
        ;;
    test)
        echo "Running Gradle tests..."
        set -x #echo on
        ( cd libs && ./run.sh test)
        ( cd modules && ./run.sh test)
        ;;
    clean)
        echo "Cleaning Gradle build..."
        set -x #echo on
        ( cd libs && ./run.sh clean)
        ( cd modules && ./run.sh clean)
        ;;
    *)
        echo "Invalid option: $1. Available options are build, publish, test, and clean."
        exit 1
        ;;
esac
