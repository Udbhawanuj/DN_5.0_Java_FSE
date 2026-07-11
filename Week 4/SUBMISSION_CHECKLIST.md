# Submission Checklist
- [x] Account and Loan REST APIs
- [x] Separate ports and independent Maven modules
- [x] Eureka Server and service registration
- [x] Greet Service through Spring Cloud Gateway
- [x] Global request logging filter
- [x] User/Order with OpenFeign + persistence
- [x] Product/Inventory with Eureka + Config Server
- [x] Customer/Billing gateway routes, rate limiting and path rewriting
- [x] Payment circuit breaker, retry, fallback logging and monitoring
- [x] Custom random load balancing configuration
- [x] OAuth2/OIDC client example
- [x] JWT issuer and resource-server examples
- [x] SonarQube, JaCoCo and JUnit demonstration
- [x] API testing and run documentation

Before portal upload on your laptop: run `mvn clean verify`. OAuth Google login needs your own client ID/secret; Redis rate limiting needs Redis (`docker compose up -d redis`).
