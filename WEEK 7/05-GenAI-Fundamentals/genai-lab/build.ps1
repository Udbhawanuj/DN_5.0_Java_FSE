$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $MyInvocation.MyCommand.Path
$build = Join-Path $root "build"
Remove-Item $build -Recurse -Force -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Path "$build\classes" -Force | Out-Null
$sources = Get-ChildItem "$root\src\main\java" -Recurse -Filter *.java | ForEach-Object FullName
javac --release 17 -d "$build\classes" $sources
if ($LASTEXITCODE -ne 0) { throw "Compilation failed" }
jar --create --file "$build\genai-lab.jar" --main-class com.udbhaw.week7.genai.Main -C "$build\classes" .
Write-Host "Created $build\genai-lab.jar" -ForegroundColor Green
