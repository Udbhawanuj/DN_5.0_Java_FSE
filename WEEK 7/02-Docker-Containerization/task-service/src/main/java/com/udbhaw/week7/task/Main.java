package com.udbhaw.week7.task;

import java.nio.file.Path;

public final class Main {
    private Main() {}

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        Path file = Path.of(System.getenv().getOrDefault("TASK_DATA_FILE", "data/tasks.tsv"));
        TaskHttpServer server = new TaskHttpServer(port, new FileTaskRepository(file));
        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
        server.start();
        System.out.println("Week 7 Task Service running on http://localhost:" + port);
        System.out.println("Health: http://localhost:" + port + "/health");
    }
}
