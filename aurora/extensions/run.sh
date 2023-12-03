#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 [build|create|test|clean]"
    exit 1
fi

identify(){
    echo "▓█████ ▒██   ██▒▄▄▄█████▓▓█████  ███▄    █   ██████  ██▓ ▒█████   ███▄    █ ";
    echo "▓█   ▀ ▒▒ █ █ ▒░▓  ██▒ ▓▒▓█   ▀  ██ ▀█   █ ▒██    ▒ ▓██▒▒██▒  ██▒ ██ ▀█   █ ";
    echo "▒███   ░░  █   ░▒ ▓██░ ▒░▒███   ▓██  ▀█ ██▒░ ▓██▄   ▒██▒▒██░  ██▒▓██  ▀█ ██▒";
    echo "▒▓█  ▄  ░ █ █ ▒ ░ ▓██▓ ░ ▒▓█  ▄ ▓██▒  ▐▌██▒  ▒   ██▒░██░▒██   ██░▓██▒  ▐▌██▒";
    echo "░▒████▒▒██▒ ▒██▒  ▒██▒ ░ ░▒████▒▒██░   ▓██░▒██████▒▒░██░░ ████▓▒░▒██░   ▓██░";
    echo "░░ ▒░ ░▒▒ ░ ░▓ ░  ▒ ░░   ░░ ▒░ ░░ ▒░   ▒ ▒ ▒ ▒▓▒ ▒ ░░▓  ░ ▒░▒░▒░ ░ ▒░   ▒ ▒ ";
    echo " ░ ░  ░░░   ░▒ ░    ░     ░ ░  ░░ ░░   ░ ▒░░ ░▒  ░ ░ ▒ ░  ░ ▒ ▒░ ░ ░░   ░ ▒░";
    echo "   ░    ░    ░    ░         ░      ░   ░ ░ ░  ░  ░   ▒ ░░ ░ ░ ▒     ░   ░ ░ ";
    echo "   ░  ░ ░    ░              ░  ░         ░       ░   ░      ░ ░           ░ ";
    echo "                                                                            ";
}

case $1 in
    build)
        identify
        echo "Running Gradle build..."
        set -x #echo on
        ( cd frontend && ./run.sh build)
        ;;
    create)
        identify
        echo "Creates files..."
        set -x #echo on
        ( cd frontend && ./run.sh create)
        ;;
    test)
        identify
        echo "Running Gradle tests..."
        set -x #echo on
        ( cd frontend && ./run.sh test)
        ;;
    clean)
        identify
        echo "Cleaning Gradle build..."
        set -x #echo on
        ( cd frontend && ./run.sh clean)
        ;;
    *)
        identify
        echo "Invalid option: $1. Available options are build, create, test, and clean."
        exit 1
        ;;
esac
