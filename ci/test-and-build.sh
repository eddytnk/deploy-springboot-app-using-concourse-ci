#!/usr/bin/env bash

set -e -u -
cd source-code-from-github/
mvn clean package
cp source-code-from-github/target/demo-1.0.jar  build-jar-file/demo.jar