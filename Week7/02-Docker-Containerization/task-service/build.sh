#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")" && pwd)"
rm -rf "$ROOT/build"
mkdir -p "$ROOT/build/classes"
find "$ROOT/src/main/java" -name '*.java' -print0 | xargs -0 javac --release 17 --add-modules jdk.httpserver -d "$ROOT/build/classes"
jar --create --file "$ROOT/build/task-service.jar" --main-class com.udbhaw.week7.task.Main -C "$ROOT/build/classes" .
echo "Created $ROOT/build/task-service.jar"
