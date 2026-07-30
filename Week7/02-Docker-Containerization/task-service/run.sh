#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")" && pwd)"
"$ROOT/build.sh"
export PORT="${PORT:-8080}"
export TASK_DATA_FILE="${TASK_DATA_FILE:-$ROOT/data/tasks.tsv}"
mkdir -p "$(dirname "$TASK_DATA_FILE")"
java --add-modules jdk.httpserver -jar "$ROOT/build/task-service.jar"
