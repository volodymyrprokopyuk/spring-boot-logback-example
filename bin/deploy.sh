#!/usr/bin/env bash

set -eu

cp -r config build/libs

#SPRING_PROFILES_ACTIVE=default java -jar build/libs/spring-boot-logback-example-0.1.0.jar "$@"
SPRING_PROFILES_ACTIVE=dev java -jar build/libs/spring-boot-logback-example-0.1.0.jar "$@"
