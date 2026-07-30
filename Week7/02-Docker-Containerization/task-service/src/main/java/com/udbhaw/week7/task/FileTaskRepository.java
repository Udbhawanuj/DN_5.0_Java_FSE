package com.udbhaw.week7.task;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public final class FileTaskRepository implements TaskRepository {
    private final Path dataFile;
    private final Map<Long, Task> tasks = new LinkedHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public FileTaskRepository(Path dataFile) {
        this.dataFile = dataFile;
        load();
    }

    @Override
    public synchronized List<Task> findAll() {
        return tasks.values().stream().sorted(Comparator.comparingLong(Task::id)).toList();
    }

    @Override
    public synchronized Optional<Task> findById(long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    @Override
    public synchronized Task create(String title, TaskStatus status) {
        Task task = new Task(sequence.incrementAndGet(), title.trim(), status, Instant.now());
        tasks.put(task.id(), task);
        persist();
        return task;
    }

    @Override
    public synchronized boolean delete(long id) {
        boolean removed = tasks.remove(id) != null;
        if (removed) persist();
        return removed;
    }

    private void load() {
        try {
            Path parent = dataFile.toAbsolutePath().getParent();
            if (parent != null) Files.createDirectories(parent);
            if (!Files.exists(dataFile)) return;
            for (String line : Files.readAllLines(dataFile, StandardCharsets.UTF_8)) {
                if (line.isBlank()) continue;
                String[] parts = line.split("\\t", 4);
                if (parts.length != 4) continue;
                long id = Long.parseLong(parts[0]);
                TaskStatus status = TaskStatus.from(parts[1]);
                Instant createdAt = Instant.parse(parts[2]);
                String title = new String(Base64.getDecoder().decode(parts[3]), StandardCharsets.UTF_8);
                tasks.put(id, new Task(id, title, status, createdAt));
                sequence.set(Math.max(sequence.get(), id));
            }
        } catch (IOException | RuntimeException ex) {
            throw new IllegalStateException("Unable to load task data from " + dataFile, ex);
        }
    }

    private void persist() {
        List<String> lines = new ArrayList<>();
        for (Task task : findAll()) {
            String title = Base64.getEncoder().encodeToString(task.title().getBytes(StandardCharsets.UTF_8));
            lines.add(task.id() + "\t" + task.status() + "\t" + task.createdAt() + "\t" + title);
        }
        try {
            Files.write(dataFile, lines, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        } catch (IOException ex) {
            throw new IllegalStateException("Unable to persist task data to " + dataFile, ex);
        }
    }
}
