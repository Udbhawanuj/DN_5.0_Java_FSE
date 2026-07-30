package com.udbhaw.week7.task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    Optional<Task> findById(long id);
    Task create(String title, TaskStatus status);
    boolean delete(long id);
}
