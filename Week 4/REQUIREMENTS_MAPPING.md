# Week 4 Requirements Mapping

## A. Code Quality and SonarQube
- `code-quality-demo`: clean service code, JUnit tests, JaCoCo report.
- Root `pom.xml`, `sonar-project.properties`, `SONARQUBE_GUIDE.md`, Docker SonarQube service.

## B. Bank Microservices Composite Hands-on
- Account API: `GET /accounts/{number}` on port 8080.
- Loan API: `GET /loans/{number}` on port 8081.
- Eureka registry: port 8761; both services are clients.
- Greet service: `GET /greet`.
- API Gateway: port 9090, Eureka discovery routing and global request logging filter.

## C. Spring Boot 3 Exercises
1. User + Order: REST, JPA persistence and OpenFeign communication.
2. Product + Inventory: Eureka discovery and centralized Config Server.
3. Customer + Billing Gateway: routing, path rewriting, Redis rate limiting and cache dependency/example.
4. Payment: Resilience4j circuit breaker, retry, fallback logging and Actuator monitoring.

## D. Sample Edge/Gateway Exercises
- Global logging filter.
- `lb://` service routing and custom `RandomLoadBalancer` bean.
- Reactive Resilience4j CircuitBreaker gateway filter and fallback endpoint.

## E. Sample Authentication Exercises
- OAuth 2.1/OIDC login client (`oauth-client-demo`; requires provider credentials).
- JWT token issuer/resource server (`auth-service`).
- Separate protected resource endpoint (`secure-resource-service`).
