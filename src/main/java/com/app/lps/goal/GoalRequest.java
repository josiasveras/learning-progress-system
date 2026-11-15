package com.app.lps.goal;

import com.app.lps.enums.Status;

import java.time.LocalDate;

public record GoalRequest(
        String name,
        String description,
        LocalDate startDate,
        LocalDate targetDate,
        Long startTaskId,
        Long targetTaskId,
        Status status
) { }
