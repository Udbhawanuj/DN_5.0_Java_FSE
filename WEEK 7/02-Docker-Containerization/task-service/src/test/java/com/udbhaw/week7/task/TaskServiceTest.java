package com.udbhaw.week7.task;

import java.nio.file.Files;
import java.nio.file.Path;

public final class TaskServiceTest {
    public static void main(String[] args) throws Exception {
        repositoryCreateReadDelete();
        jsonRoundTripFields();
        invalidStatusIsRejected();
        System.out.println("Task Service tests passed.");
    }

    private static void repositoryCreateReadDelete() throws Exception {
        Path dir = Files.createTempDirectory("week7-task-test");
        Path file = dir.resolve("tasks.tsv");
        FileTaskRepository repository = new FileTaskRepository(file);
        Task first = repository.create("Learn Docker", TaskStatus.IN_PROGRESS);
        require(first.id() == 1, "First task id must be 1");
        require(repository.findAll().size() == 1, "Task must be stored");
        FileTaskRepository reloaded = new FileTaskRepository(file);
        require(reloaded.findById(1).orElseThrow().title().equals("Learn Docker"), "Task must persist");
        require(reloaded.delete(1), "Task must be deleted");
        require(reloaded.findAll().isEmpty(), "Repository must be empty");
    }

    private static void jsonRoundTripFields() {
        String json = "{\"title\":\"Week 7\\nLab\",\"status\":\"DONE\"}";
        require(JsonSupport.field(json, "title").equals("Week 7\nLab"), "Title field parsing failed");
        require(JsonSupport.field(json, "status").equals("DONE"), "Status field parsing failed");
    }

    private static void invalidStatusIsRejected() {
        boolean thrown = false;
        try { TaskStatus.from("INVALID"); } catch (IllegalArgumentException ex) { thrown = true; }
        require(thrown, "Invalid status must be rejected");
    }

    private static void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
