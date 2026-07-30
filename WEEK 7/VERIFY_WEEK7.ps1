$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $MyInvocation.MyCommand.Path

Write-Host "[1/3] Verifying Java Task Service..." -ForegroundColor Cyan
& "$root\02-Docker-Containerization\task-service\test.ps1"

Write-Host "[2/3] Verifying GenAI Lab..." -ForegroundColor Cyan
& "$root\05-GenAI-Fundamentals\genai-lab\test.ps1"

Write-Host "[3/3] Checking required Week 7 files..." -ForegroundColor Cyan
$required = @(
  "01-DevOps-CICD\PIPELINE_GUIDE.md",
  "02-Docker-Containerization\docker-compose.yml",
  "02-Docker-Containerization\task-service\Dockerfile",
  "03-Agile-Methodology\PRODUCT_BACKLOG.md",
  "04-Cloud-Fundamentals\cloudformation\s3-secure-bucket.yaml",
  "05-GenAI-Fundamentals\genai-lab\src\main\java\com\udbhaw\week7\genai\Main.java"
)
foreach ($item in $required) {
  if (-not (Test-Path (Join-Path $root $item))) { throw "Missing required file: $item" }
}

Write-Host "WEEK 7 VERIFICATION PASSED" -ForegroundColor Green
