# SonarQube Hands-on
1. Run `docker compose up -d sonarqube` and open `http://localhost:9000`.
2. Create a local project and generate a token.
3. Run `mvn clean verify sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.token=TOKEN`.
4. Review bugs, vulnerabilities, code smells, duplicated lines, cyclomatic complexity and coverage.
5. Quality Gate interpretation: pass means configured thresholds are met; fail means fix new-code issues and rescan.
The `code-quality-demo` module intentionally demonstrates small methods, input validation and unit tests for clean static analysis.
