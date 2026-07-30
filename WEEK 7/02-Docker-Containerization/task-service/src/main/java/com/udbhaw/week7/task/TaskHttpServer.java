package com.udbhaw.week7.task;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.concurrent.Executors;

public final class TaskHttpServer {
    private final HttpServer server;
    private final TaskRepository repository;

    public TaskHttpServer(int port, TaskRepository repository) throws IOException {
        this.repository = repository;
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
        this.server.createContext("/health", this::health);
        this.server.createContext("/api/tasks", this::tasks);
        this.server.setExecutor(Executors.newFixedThreadPool(8));
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop(0);
    }

    private void health(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            send(exchange, 405, JsonSupport.message("Method not allowed"));
            return;
        }
        send(exchange, 200, "{\"status\":\"UP\",\"service\":\"week7-task-service\"}");
    }

    private void tasks(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod().toUpperCase();
        String path = exchange.getRequestURI().getPath();
        String suffix = path.substring("/api/tasks".length());

        try {
            if (suffix.isEmpty() || suffix.equals("/")) {
                if (method.equals("GET")) {
                    send(exchange, 200, JsonSupport.tasks(repository.findAll()));
                } else if (method.equals("POST")) {
                    String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
                    String title = JsonSupport.field(body, "title");
                    TaskStatus status = TaskStatus.from(JsonSupport.field(body, "status"));
                    Task created = repository.create(title, status);
                    exchange.getResponseHeaders().add("Location", "/api/tasks/" + created.id());
                    send(exchange, 201, JsonSupport.task(created));
                } else {
                    send(exchange, 405, JsonSupport.message("Method not allowed"));
                }
                return;
            }

            long id = Long.parseLong(suffix.substring(1));
            if (method.equals("GET")) {
                Optional<Task> task = repository.findById(id);
                if (task.isPresent()) send(exchange, 200, JsonSupport.task(task.get()));
                else send(exchange, 404, JsonSupport.message("Task not found"));
            } else if (method.equals("DELETE")) {
                if (repository.delete(id)) send(exchange, 200, JsonSupport.message("Task deleted"));
                else send(exchange, 404, JsonSupport.message("Task not found"));
            } else {
                send(exchange, 405, JsonSupport.message("Method not allowed"));
            }
        } catch (IllegalArgumentException ex) {
            send(exchange, 400, JsonSupport.message(ex.getMessage()));
        } catch (RuntimeException ex) {
            send(exchange, 500, JsonSupport.message("Internal server error"));
        }
    }

    private static void send(HttpExchange exchange, int status, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.getResponseHeaders().set("Cache-Control", "no-store");
        exchange.sendResponseHeaders(status, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
    }
}
