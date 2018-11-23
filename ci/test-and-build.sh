#!/usr/bin/env bash

set -e -u -
cd source-code-from-github/
./mvnw clean package
cp ./source-code-from-github/target/*.jar  ./jar_file/