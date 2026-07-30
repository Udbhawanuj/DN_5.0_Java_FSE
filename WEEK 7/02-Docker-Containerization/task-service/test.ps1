$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $MyInvocation.MyCommand.Path
& "$root\build.ps1"
New-Item -ItemType Directory -Path "$root\build\test-classes" -Force | Out-Null
$tests = Get-ChildItem "$root\src\test\java" -Recurse -Filter *.java | ForEach-Object FullName
javac --release 17 --add-modules jdk.httpserver -cp "$root\build\classes" -d "$root\build\test-classes" $tests
if ($LASTEXITCODE -ne 0) { throw "Test compilation failed" }
java -ea --add-modules jdk.httpserver -cp "$root\build\classes;$root\build\test-classes" com.udbhaw.week7.task.TaskServiceTest
if ($LASTEXITCODE -ne 0) { throw "Tests failed" }
