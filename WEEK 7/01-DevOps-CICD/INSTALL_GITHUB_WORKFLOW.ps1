$ErrorActionPreference = "Stop"
$week7Root = Split-Path -Parent $PSScriptRoot
$repoRoot = Split-Path -Parent $week7Root
$workflowDirectory = Join-Path $repoRoot ".github\workflows"
New-Item -ItemType Directory -Path $workflowDirectory -Force | Out-Null
Copy-Item (Join-Path $PSScriptRoot "week7-ci.yml") (Join-Path $workflowDirectory "week7-ci.yml") -Force
Write-Host "Installed workflow at $workflowDirectory\week7-ci.yml" -ForegroundColor Green
