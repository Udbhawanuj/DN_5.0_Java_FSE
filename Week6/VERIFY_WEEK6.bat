@echo off
echo Verifying all Week 6 applications...
call npm install
if errorlevel 1 pause & exit /b 1
call npm run verify
pause
