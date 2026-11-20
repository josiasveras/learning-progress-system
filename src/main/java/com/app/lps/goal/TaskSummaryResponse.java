package com.app.lps.goal;

import com.app.lps.enums.Status;

public record TaskSummaryResponse(
        Long id,
        Integer number,
        String title,
        Status status
) {}
