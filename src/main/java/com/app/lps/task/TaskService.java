package com.app.lps.task;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
        return task.stream().map(t -> new TaskResponse(t.getId(), t.getGoalId(), t.getNumber(), t.getTitle(), t.getDescription(), t.getStatus(), t.getStartDate(), t.getDueDate(), t.getCompletedDate(), t.getDifficulty(), t.getCreatedAt()));
    }

    public TaskResponse getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.map(t -> new TaskResponse(t.getId(), t.getGoalId(), t.getNumber(), t.getTitle(), t.getDescription(), t.getStatus(), t.getStartDate(), t.getDueDate(), t.getCompletedDate(), t.getDifficulty(), t.getCreatedAt())).orElse(null);
    }

    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = new Task(taskRequest.goalId(), taskRequest.number(), taskRequest.title(), taskRequest.description(), taskRequest.status(), taskRequest.startDate(), taskRequest.dueDate(), taskRequest.completedDate(), taskRequest.difficulty());
        taskRepository.save(task);
        return new TaskResponse(task.getId(), task.getGoalId(), task.getNumber(), task.getTitle(), task.getDescription(), task.getStatus(), task.getStartDate(), task.getDueDate(), task.getCompletedDate(), task.getDifficulty(), task.getCreatedAt());
    }

    public void deleteTaskById(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with ID " + id + " not found.");
        }

        taskRepository.deleteById(id);
    }

    @Transactional
    public TaskResponse updateTaskById(Long id, TaskRequest taskRequest) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with ID " + id + " not found."));

        task.setGoalId(taskRequest.goalId());
        task.setNumber(taskRequest.number());
        task.setTitle(taskRequest.title());
        task.setDescription(taskRequest.description());
        task.setStatus(taskRequest.status());
        task.setStartDate(taskRequest.startDate());
        task.setDueDate(taskRequest.dueDate());
        task.setCompletedDate(taskRequest.completedDate());
        task.setDifficulty(taskRequest.difficulty());

        return new TaskResponse(task.getId(), task.getGoalId(), task.getNumber(), task.getTitle(), task.getDescription(), task.getStatus(), task.getStartDate(), task.getDueDate(), task.getCompletedDate(), task.getDifficulty(), task.getCreatedAt());
    }
}
