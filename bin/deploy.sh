#!/usr/bin/env bash

set -eu

cp -r config build/libs
java -jar build/libs/spring-boot-logback-example-0.1.0.jar "$@"
