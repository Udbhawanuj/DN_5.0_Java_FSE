# Java Task Service

A dependency-free Java 17 HTTP service using the JDK `HttpServer` module.

## Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/health` | Health check |
| GET | `/api/tasks` | List tasks |
| POST | `/api/tasks` | Create a task |
| GET | `/api/tasks/{id}` | Fetch a task |
| DELETE | `/api/tasks/{id}` | Delete a task |

Example JSON:

```json
{"title":"Learn Docker","status":"IN_PROGRESS"}
```
