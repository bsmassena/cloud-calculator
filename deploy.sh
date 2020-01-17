#!/bin/bash

set -e

# Build gradle project
./gradlew clean fatJar

# Build docker image
docker build -t calc-rxnetty .

# Run docker container
docker run -p 8080:8888 -d calc-rxnetty