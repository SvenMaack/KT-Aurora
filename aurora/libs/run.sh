#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 [build|publish|test|clean]"
    exit 1
fi

case $1 in
    build)
        echo "Running Gradle build..."
        set -x #echo on
        ( cd css && ./run.sh build)
        ( cd template && ./run.sh build)
        ( cd page && ./run.sh build)
        ;;
    publish)
        echo "Publish to Local Repository..."
        set -x #echo on
        ( cd css && ./run.sh publish)
        ( cd template && ./run.sh publish)
        ( cd page && ./run.sh publish)
        ;;
    test)
        echo "Running Gradle tests..."
        set -x #echo on
        ( cd css && ./run.sh test)
        ( cd template && ./run.sh test)
        ( cd page && ./run.sh test)
        ;;
    clean)
        echo "Cleaning Gradle build..."
        set -x #echo on
        ( cd css && ./run.sh clean)
        ( cd template && ./run.sh clean)
        ( cd page && ./run.sh clean)
        ;;
    *)
        echo "Invalid option: $1. Available options are build, publish, test, and clean."
        exit 1
        ;;
esac
