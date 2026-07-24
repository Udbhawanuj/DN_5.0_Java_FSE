@echo off
echo Installing Week 6 dependencies...
call npm install
if errorlevel 1 pause & exit /b 1
call npm start
