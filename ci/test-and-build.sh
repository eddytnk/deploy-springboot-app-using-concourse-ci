#!/usr/bin/env bash

set -e -u -
cd source-code-from-github/
mvn clean package
cp source-code-from-github/target/*.jar  jar-file/