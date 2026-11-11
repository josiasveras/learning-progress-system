package com.app.lps.task;

import com.app.lps.goal.Goal;
import com.app.lps.goal.GoalRepository;
import com.app.lps.goal.GoalSummaryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Stream;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final GoalRepository goalRepository;

    public TaskService(TaskRepository taskRepository, GoalRepository goalRepository) {
        this.taskRepository = taskRepository;
        this.goalRepository = goalRepository;
    }

    public GoalSummaryResponse toGoalSummaryResponse(final Goal goalEntity) {
        return new GoalSummaryResponse(
                goalEntity.getId(),
                goalEntity.getName(),
                goalEntity.getDescription(),
                goalEntity.getStartDate(),
                goalEntity.getTargetDate(),
                goalEntity.getStatus()
        );
    }

    private TaskResponse toTaskResponse(Task task) {
        GoalSummaryResponse goalSummary = toGoalSummaryResponse(task.getGoal());

        return new TaskResponse(
                task.getId(),
                goalSummary,
                task.getNumber(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getStartDate(),
                task.getDueDate(),
                task.getCompletedDate(),
                task.getDifficulty(),
                task.getCreatedAt(),
                task.getContentLink(),
                task.getNote()
        );
    }

    public Stream<TaskResponse> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(this::toTaskResponse);
    }

    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with ID " + id + " not found."));

        return toTaskResponse(task);
    }

    public TaskResponse createTask(TaskRequest taskRequest) {
        Goal goal = goalRepository.findById(taskRequest.goalId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal with ID " + taskRequest.goalId() + " not found."));

        Task task = new Task(goal, taskRequest.number(), taskRequest.title(), taskRequest.description(), taskRequest.status(), taskRequest.startDate(), taskRequest.dueDate(), taskRequest.completedDate(), taskRequest.difficulty(), taskRequest.contentLink(), taskRequest.note());

        Task savedTask = taskRepository.save(task);

        return toTaskResponse(savedTask);
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

        Goal goal = goalRepository.findById(taskRequest.goalId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal with ID " + taskRequest.goalId() + " not found."));

        task.setGoal(goal);
        task.setNumber(taskRequest.number());
        task.setTitle(taskRequest.title());
        task.setDescription(taskRequest.description());
        task.setStatus(taskRequest.status());
        task.setStartDate(taskRequest.startDate());
        task.setDueDate(taskRequest.dueDate());
        task.setCompletedDate(taskRequest.completedDate());
        task.setDifficulty(taskRequest.difficulty());
        task.setContentLink(taskRequest.contentLink());
        task.setNote(taskRequest.note());

        Task updatedTask = taskRepository.save(task);

        return toTaskResponse(updatedTask);
    }

    @Transactional
    public TaskResponse updateTaskPartiallyById(Long id, TaskRequest taskRequest) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with ID " + id + " not found."));

        if (taskRequest.goalId() != null) {
            Goal goal = goalRepository.findById(taskRequest.goalId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal with ID " + taskRequest.goalId() + " not found."));
            task.setGoal(goal);
        }
        if (taskRequest.number() != null) {
            task.setNumber(taskRequest.number());
        }
        if (taskRequest.title() != null) {
            task.setTitle(taskRequest.title());
        }
        if (taskRequest.description() != null) {
            task.setDescription(taskRequest.description());
        }
        if (taskRequest.status() != null) {
            task.setStatus(taskRequest.status());
        }
        if (taskRequest.startDate() != null) {
            task.setStartDate(taskRequest.startDate());
        }
        if (taskRequest.dueDate() != null) {
            task.setDueDate(taskRequest.dueDate());
        }
        if (taskRequest.completedDate() != null) {
            task.setCompletedDate(taskRequest.completedDate());
        }
        if (taskRequest.difficulty() != null) {
            task.setDifficulty(taskRequest.difficulty());
        }
        if (taskRequest.contentLink() != null) {
            task.setContentLink(taskRequest.contentLink());
        }
        if (taskRequest.note() != null) {
            task.setNote(taskRequest.note());
        }

        Task updatedTask = taskRepository.save(task);

        return toTaskResponse(updatedTask);
    }
}
