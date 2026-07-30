package com.udbhaw.week7.task;

import java.time.Instant;

public record Task(long id, String title, TaskStatus status, Instant createdAt) {
    public Task {
        if (id < 1) throw new IllegalArgumentException("id must be positive");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title is required");
        if (status == null) throw new IllegalArgumentException("status is required");
        if (createdAt == null) throw new IllegalArgumentException("createdAt is required");
    }
}
