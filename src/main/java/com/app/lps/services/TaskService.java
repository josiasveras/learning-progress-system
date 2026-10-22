package com.app.lps.services;

import com.app.lps.models.Task;
import com.app.lps.records.TaskResponse;
import com.app.lps.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Stream<TaskResponse> getTasks() {
        List<Task> task = taskRepository.findAll();
        return task.stream().map(t -> new TaskResponse(t.getNumber(), t.getTitle(), t.getDescription(), t.getStatus(), t.getStartDate(), t.getDueDate(), t.getCompletedDate(), t.getDifficulty(), t.getCreatedAt()));
    }

    public TaskResponse getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.map(t -> new TaskResponse(t.getNumber(), t.getTitle(), t.getDescription(), t.getStatus(), t.getStartDate(), t.getDueDate(), t.getCompletedDate(), t.getDifficulty(), t.getCreatedAt())).orElse(null);
    }
}
