package com.app.lps.goal;

import com.app.lps.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Goal {

    @Id
    @Column(name = "goal_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "goal_name", nullable = false)
    private String name;

    @Column(name = "goal_description")
    private String description;

    @Column(name = "goal_start_date")
    private LocalDate startDate;

    @Column(name = "goal_target_date")
    private LocalDate targetDate;

    @Column(name = "start_task_id")
    private Long startTaskId;

    @Column(name = "target_task_id")
    private Long targetTaskId;

    @Enumerated(EnumType.STRING)
    @Column(name = "goal_status", nullable = false)
    private Status status = Status.PLANNED;

    @Column(name = "goal_created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Goal(){
    }

    public Goal(Long id, String name, String description, LocalDate startDate, LocalDate targetDate, Long startTaskId, Long targetTaskId, Status status, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.targetDate = targetDate;
        this.startTaskId = startTaskId;
        this.targetTaskId = targetTaskId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public Long getStartTaskId() {
        return startTaskId;
    }

    public void setStartTaskId(Long startTaskId) {
        this.startTaskId = startTaskId;
    }

    public Long getTargetTaskId() {
        return targetTaskId;
    }

    public void setTargetTaskId(Long targetTaskId) {
        this.targetTaskId = targetTaskId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
