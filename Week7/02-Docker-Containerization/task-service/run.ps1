$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $MyInvocation.MyCommand.Path
& "$root\build.ps1"
if (-not $env:PORT) { $env:PORT = "8080" }
if (-not $env:TASK_DATA_FILE) { $env:TASK_DATA_FILE = "$root\data\tasks.tsv" }
New-Item -ItemType Directory -Path (Split-Path -Parent $env:TASK_DATA_FILE) -Force | Out-Null
java --add-modules jdk.httpserver -jar "$root\build\task-service.jar"
