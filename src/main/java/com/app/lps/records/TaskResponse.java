package com.app.lps.records;

import com.app.lps.models.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponse(Integer number, String title, String description, TaskStatus status,LocalDateTime startDate, LocalDateTime dueDate, LocalDateTime completedDate, String difficulty, LocalDateTime createdAt) {
}
