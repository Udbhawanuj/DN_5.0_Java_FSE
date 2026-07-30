FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /source
COPY src ./src
RUN mkdir -p build/classes \
    && find src/main/java -name "*.java" -print0 | xargs -0 javac --release 17 --add-modules jdk.httpserver -d build/classes \
    && jar --create --file build/task-service.jar --main-class com.udbhaw.week7.task.Main -C build/classes .

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
RUN apk add --no-cache wget && mkdir -p /app/data
COPY --from=build /source/build/task-service.jar /app/task-service.jar
ENV PORT=8080
ENV TASK_DATA_FILE=/app/data/tasks.tsv
EXPOSE 8080
HEALTHCHECK --interval=10s --timeout=3s --retries=5 CMD wget -q --spider http://localhost:8080/health || exit 1
ENTRYPOINT ["java", "--add-modules", "jdk.httpserver", "-jar", "/app/task-service.jar"]
