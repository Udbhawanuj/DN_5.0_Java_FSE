package com.udbhaw.week7.task;

public enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE;

    public static TaskStatus from(String value) {
        if (value == null || value.isBlank()) {
            return TODO;
        }
        try {
            return TaskStatus.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Status must be TODO, IN_PROGRESS or DONE");
        }
    }
}
