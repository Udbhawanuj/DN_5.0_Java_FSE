@echo off
start "Eureka" cmd /k "mvn -pl eureka-server spring-boot:run"
timeout /t 10
start "Config" cmd /k "mvn -pl config-server spring-boot:run"
start "Gateway" cmd /k "mvn -pl api-gateway spring-boot:run"
start "Account" cmd /k "mvn -pl account-service spring-boot:run"
start "Loan" cmd /k "mvn -pl loan-service spring-boot:run"
start "Greet" cmd /k "mvn -pl greet-service spring-boot:run"
echo Core Week 4 services launched.
