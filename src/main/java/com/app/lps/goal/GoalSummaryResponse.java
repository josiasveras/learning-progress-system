package com.app.lps.goal;

import com.app.lps.enums.Status;

import java.time.LocalDate;

public record GoalSummaryResponse(
        Long id,
        String name,
        String description,
        LocalDate startDate,
        LocalDate targetDate,
        Status status
) { }
