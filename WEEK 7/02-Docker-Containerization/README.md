# Docker Containerization Hands-on

This module containerizes a Java 17 REST task service.

## Demonstrated Concepts

- Docker Engine, CLI and daemon
- image layers and multi-stage builds
- `docker run` naming, ports and environment variables
- container lifecycle commands
- Docker Compose
- named volumes for persistent task data
- custom bridge network
- Nginx reverse proxy
- health checks
- basic Kubernetes orchestration manifests

## Docker Compose

```powershell
docker compose up --build
Invoke-RestMethod http://localhost:8080/health
docker compose ps
docker compose logs -f
docker compose down
```

To remove the stored task volume as well:

```powershell
docker compose down -v
```
