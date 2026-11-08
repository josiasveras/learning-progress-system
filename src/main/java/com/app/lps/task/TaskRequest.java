package com.app.lps.task;

import com.app.lps.enums.Difficulty;
import com.app.lps.enums.Status;

import java.time.LocalDateTime;

public record TaskRequest(
        Long goalId,
        Integer number,
        String title,
        String description,
        Status status,
        LocalDateTime startDate,
        LocalDateTime dueDate,
        LocalDateTime completedDate,
        Difficulty difficulty,
        String contentLink,
        String note
) { }
