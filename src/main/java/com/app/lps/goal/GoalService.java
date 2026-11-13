package com.app.lps.goal;

import com.app.lps.task.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
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
}
