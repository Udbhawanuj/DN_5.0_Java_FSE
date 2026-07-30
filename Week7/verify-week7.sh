#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")" && pwd)"
"$ROOT/02-Docker-Containerization/task-service/test.sh"
"$ROOT/05-GenAI-Fundamentals/genai-lab/test.sh"
for f in \
  "01-DevOps-CICD/PIPELINE_GUIDE.md" \
  "02-Docker-Containerization/docker-compose.yml" \
  "02-Docker-Containerization/task-service/Dockerfile" \
  "03-Agile-Methodology/PRODUCT_BACKLOG.md" \
  "04-Cloud-Fundamentals/cloudformation/s3-secure-bucket.yaml" \
  "05-GenAI-Fundamentals/genai-lab/src/main/java/com/udbhaw/week7/genai/Main.java"; do
  test -f "$ROOT/$f" || { echo "Missing: $f"; exit 1; }
done
echo "WEEK 7 VERIFICATION PASSED"
