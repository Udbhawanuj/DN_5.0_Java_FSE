# Docker Commands Lab

```bash
# Images
docker pull eclipse-temurin:17-jre
docker images
docker image inspect week7-task-service
docker rmi week7-task-service

# Build
docker build -t week7-task-service:1.0 ./task-service

# Run
docker run --name week7-task-api -p 8080:8080 week7-task-service:1.0
docker run -d --name week7-task-api -p 8080:8080 -e PORT=8080 week7-task-service:1.0

# Containers
docker ps
docker ps -a
docker logs -f week7-task-api
docker stop week7-task-api
docker start week7-task-api
docker rm -f week7-task-api

# Networks
docker network ls
docker network create week7-network
docker network inspect week7-network

# Volumes
docker volume create task-data
docker volume ls
docker volume inspect task-data

# Compose
docker compose up --build
docker compose ps
docker compose logs -f
docker compose down
docker compose down -v
```
