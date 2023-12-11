#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 [build|create|test|clean]"
    exit 1
fi

identify(){
    echo " ██▓     ██▓ ▄▄▄▄    ██▀███   ▄▄▄       ██▀███ ▓██   ██▓";
    echo "▓██▒    ▓██▒▓█████▄ ▓██ ▒ ██▒▒████▄    ▓██ ▒ ██▒▒██  ██▒";
    echo "▒██░    ▒██▒▒██▒ ▄██▓██ ░▄█ ▒▒██  ▀█▄  ▓██ ░▄█ ▒ ▒██ ██░";
    echo "▒██░    ░██░▒██░█▀  ▒██▀▀█▄  ░██▄▄▄▄██ ▒██▀▀█▄   ░ ▐██▓░";
    echo "░██████▒░██░░▓█  ▀█▓░██▓ ▒██▒ ▓█   ▓██▒░██▓ ▒██▒ ░ ██▒▓░";
    echo "░ ▒░▓  ░░▓  ░▒▓███▀▒░ ▒▓ ░▒▓░ ▒▒   ▓▒█░░ ▒▓ ░▒▓░  ██▒▒▒ ";
    echo "░ ░ ▒  ░ ▒ ░▒░▒   ░   ░▒ ░ ▒░  ▒   ▒▒ ░  ░▒ ░ ▒░▓██ ░▒░ ";
    echo "  ░ ░    ▒ ░ ░    ░   ░░   ░   ░   ▒     ░░   ░ ▒ ▒ ░░  ";
    echo "    ░  ░ ░   ░         ░           ░  ░   ░     ░ ░     ";
    echo "                  ░                             ░ ░     ";
}

case $1 in
    build)
        identify
        echo "Running Gradle build..."
        set -x #echo on
        ( cd css && ./run.sh build)
        ( cd template && ./run.sh build)
        ( cd di && ./run.sh build)
        ( cd page && ./run.sh build)
        ;;
    create)
        identify
        echo "Creates files..."
        set -x #echo on
        ( cd css && ./run.sh create)
        ( cd template && ./run.sh create)
        ( cd di && ./run.sh create)
        ( cd page && ./run.sh create)
        ;;
    test)
        identify
        echo "Running Gradle tests..."
        set -x #echo on
        ( cd css && ./run.sh test)
        ( cd template && ./run.sh test)
        ( cd di && ./run.sh test)
        ( cd page && ./run.sh test)
        ;;
    clean)
        identif
        echo "Cleaning Gradle build..."
        set -x #echo on
        ( cd css && ./run.sh clean)
        ( cd template && ./run.sh clean)
        ( cd di && ./run.sh clean)
        ( cd page && ./run.sh clean)
        ;;
    *)
        identify
        echo "Invalid option: $1. Available options are build, create, test, and clean."
        exit 1
        ;;
esac
