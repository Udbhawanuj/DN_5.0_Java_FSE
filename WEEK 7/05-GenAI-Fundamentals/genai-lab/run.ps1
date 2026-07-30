$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $MyInvocation.MyCommand.Path
& "$root\build.ps1"
java -jar "$root\build\genai-lab.jar"
