package com.app.lps.goal;

import com.app.lps.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record GoalResponse(
        Long id,
        String name,
        String description,
        LocalDate startDate,
        LocalDate targetDate,
        List<TaskSummaryResponse> tasks,
        TaskSummaryResponse startTask,
        TaskSummaryResponse targetTask,
        Status status,
        LocalDateTime createdAt
) { }
