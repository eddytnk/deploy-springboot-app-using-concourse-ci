#!/usr/bin/env bash

set -e -u -
 cd source-code-from-github/
./mvnw clean package
cp source-code-from-github/target/demo-1.0.jar build/demo.jar