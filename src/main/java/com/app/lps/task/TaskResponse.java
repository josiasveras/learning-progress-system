package com.app.lps.task;

import com.app.lps.enums.Difficulty;
import com.app.lps.enums.Status;
import com.app.lps.goal.GoalSummaryResponse;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        GoalSummaryResponse goalSummaryResponse,
        Integer number,
        String title,
        String description,
        Status status,
        LocalDateTime startDate,
        LocalDateTime dueDate,
        LocalDateTime completedDate,
        Difficulty difficulty,
        LocalDateTime createdAt,
        String contentLink,
        String note
) {}
