package com.app.lps.goal;

import com.app.lps.task.Task;
import com.app.lps.task.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final TaskRepository taskRepository;

    public GoalService(GoalRepository goalRepository, TaskRepository taskRepository) {
        this.goalRepository = goalRepository;
        this.taskRepository = taskRepository;
    }

    private TaskSummaryResponse toTaskSummaryResponse(Task task) {
        if (task == null) {
            return null;
        }
        return new TaskSummaryResponse(
                task.getId(),
                task.getNumber(),
                task.getTitle(),
                task.getStatus()
        );
    }

    private GoalResponse toGoalResponse(Goal goal) {
        TaskSummaryResponse startTaskSummary = toTaskSummaryResponse(goal.getStartTask());
        TaskSummaryResponse TargetTaskSummary = toTaskSummaryResponse(goal.getTargetTask());

        List<TaskSummaryResponse> taskSummaries = goal.getTasks().stream()
                .map(this::toTaskSummaryResponse)
                .toList();

        return new GoalResponse(
                goal.getId(),
                goal.getName(),
                goal.getDescription(),
                goal.getStartDate(),
                goal.getTargetDate(),
                taskSummaries,
                startTaskSummary,
                TargetTaskSummary,
                goal.getStatus(),
                goal.getCreatedAt()
        );
    }

    public List<GoalResponse> getGoals() {
        List<Goal> goals = goalRepository.findAll();

        return goals.stream()
                .map(this::toGoalResponse)
                .toList();
    }

    public GoalResponse getGoalById(Long id) {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal with ID " + id + " not found."));

        return toGoalResponse(goal);
    }

    public GoalResponse createGoal(GoalRequest goalRequest) {
        Goal goal = new Goal(goalRequest.name(), goalRequest.description(), goalRequest.startDate(), goalRequest.targetDate(), null, null, goalRequest.status());

        Goal savedGoal = goalRepository.save(goal);

        return toGoalResponse(savedGoal);
    }

    @Transactional
    public GoalResponse updateGoalById(Long id, GoalRequest goalRequest) {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal with ID " + id + " not found."));

        goal.setName(goalRequest.name());
        goal.setDescription(goalRequest.description());
        goal.setStartDate(goalRequest.startDate());
        goal.setTargetDate(goalRequest.targetDate());
        if (goalRequest.startTaskId() != null) {
            Task startTask = taskRepository.findById(goalRequest.startTaskId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with ID " + goalRequest.startTaskId() + " not found."));
            goal.setStartTask(startTask);
        }
        if (goalRequest.targetTaskId() != null) {
            Task targetTask = taskRepository.findById(goalRequest.targetTaskId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with ID " + goalRequest.targetTaskId() + " not found."));
            goal.setTargetTask(targetTask);
        }
        goal.setStatus(goalRequest.status());

        Goal updatedGoal = goalRepository.save(goal);

        return toGoalResponse(updatedGoal);
    }

    @Transactional
    public GoalResponse updateGoalPartiallyById(Long id, GoalRequest goalRequest) {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal with ID " + id + " not found."));

        if (goalRequest.name() != null) {
            goal.setName(goalRequest.name());
        }
        if (goalRequest.description() != null) {
            goal.setDescription(goalRequest.description());
        }
        if (goalRequest.startDate() != null) {
            goal.setStartDate(goalRequest.startDate());
        }
        if (goalRequest.targetDate() != null) {
            goal.setTargetDate(goalRequest.targetDate());
        }
        if (goalRequest.startTaskId() != null) {
            Task startTask = taskRepository.findById(goalRequest.startTaskId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with ID " + goalRequest.startTaskId() + " not found."));
            goal.setStartTask(startTask);
        }
        if (goalRequest.targetTaskId() != null) {
            Task targetTask = taskRepository.findById(goalRequest.targetTaskId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with ID " + goalRequest.targetTaskId() + " not found."));
            goal.setTargetTask(targetTask);
        }
        if (goalRequest.status() != null) {
            goal.setStatus(goalRequest.status());
        }

        Goal updatedGoal = goalRepository.save(goal);

        return toGoalResponse(updatedGoal);
    }
}
