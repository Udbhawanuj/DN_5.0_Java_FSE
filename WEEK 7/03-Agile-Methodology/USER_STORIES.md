# User Stories

## US-01 — Health Monitoring

**As an** operations engineer, **I want** a health endpoint **so that** the platform can detect service failure.

Acceptance criteria:

- `GET /health` returns HTTP 200.
- The response contains `status: UP`.
- Docker and Kubernetes health checks use the endpoint.

## US-02 — Create Task

**As a** learner, **I want** to create a task **so that** I can track Week 7 activities.

Acceptance criteria:

- title is mandatory
- supported statuses are `TODO`, `IN_PROGRESS` and `DONE`
- successful creation returns HTTP 201 and a generated id

## US-03 — Persistent Container Data

**As a** user, **I want** tasks to survive container recreation **so that** my work is not lost.

Acceptance criteria:

- Compose attaches a named volume
- the service reads and writes task data under `/app/data`
- `docker compose down` preserves data unless `-v` is supplied

## US-04 — Automated Quality Gate

**As a** developer, **I want** every change compiled and tested **so that** broken code is not merged.
