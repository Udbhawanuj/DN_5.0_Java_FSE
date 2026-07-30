#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")" && pwd)"
"$ROOT/build.sh"
mkdir -p "$ROOT/build/test-classes"
find "$ROOT/src/test/java" -name '*.java' -print0 | xargs -0 javac --release 17 -cp "$ROOT/build/classes" -d "$ROOT/build/test-classes"
java -ea -cp "$ROOT/build/classes:$ROOT/build/test-classes" com.udbhaw.week7.genai.GenAILabTest
