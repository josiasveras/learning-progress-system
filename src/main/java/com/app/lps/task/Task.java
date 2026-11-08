package com.app.lps.task;

import com.app.lps.enums.Difficulty;
import com.app.lps.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Column(name = "task_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "goal_id", nullable = false)
    private Long goalId;

    @Column(name = "task_number", nullable = false)
    private Integer number;

    @Column(name = "task_title", nullable = false)
    private String title;

    @Column(name = "task_description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status", nullable = false)
    private Status status = Status.PLANNED;

    @Column(name = "task_start_date")
    private LocalDateTime startDate;

    @Column(name = "task_due_date")
    private LocalDateTime dueDate;

    @Column(name = "task_completed_date")
    private LocalDateTime completedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_difficulty", nullable = false)
    private Difficulty difficulty = Difficulty.MODERATE;

    @Column(name = "task_created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "task_content_link")
    private String contentLink;

    @Column(name = "task_note")
    private String note;

    public Task() {
    }

    public Task(Long id, Long goalId, Integer number, String title, String description, Status status, LocalDateTime startDate, LocalDateTime dueDate, LocalDateTime completedDate, Difficulty difficulty, LocalDateTime createdAt, String contentLink, String note) {
        this.id = id;
        this.goalId = goalId;
        this.number = number;
        this.title = title;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.completedDate = completedDate;
        this.difficulty = difficulty;
        this.createdAt = createdAt;
        this.contentLink = contentLink;
        this.note = note;
    }

    public Task(Long goalId, Integer number, String title, String description, Status status, LocalDateTime startDate, LocalDateTime dueDate, LocalDateTime completedDate, Difficulty difficulty, String contentLink, String note) {
        this.goalId = goalId;
        this.number = number;
        this.title = title;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.completedDate = completedDate;
        this.difficulty = difficulty;
        this.contentLink = contentLink;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getContentLink() {
        return contentLink;
    }

    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
