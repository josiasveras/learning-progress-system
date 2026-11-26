package com.app.lps.studysession;

import com.app.lps.enums.Comprehension;
import com.app.lps.enums.Difficulty;
import com.app.lps.task.Task;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "study_sessions")
public class StudySession {

    @Id
    @Column(name = "study_session_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "study_session_date")
    private Date date;

    @Column(name = "study_session_duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(name = "study_session_comprehension", nullable = false)
    private Comprehension comprehension = Comprehension.AVERAGE;

    @Enumerated(EnumType.STRING)
    @Column(name = "study_session_difficulty", nullable = false)
    private Difficulty difficulty = Difficulty.MODERATE;

    @Column(name = "study_session_note")
    private String note;

    @Column(name = "study_session_created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public StudySession(Long id, Task task, Date date, Integer durationMinutes, Comprehension comprehension, Difficulty difficulty, String note, LocalDateTime createdAt) {
        this.id = id;
        this.task = task;
        this.date = date;
        this.durationMinutes = durationMinutes;
        this.comprehension = comprehension;
        this.difficulty = difficulty;
        this.note = note;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Comprehension getComprehension() {
        return comprehension;
    }

    public void setComprehension(Comprehension comprehension) {
        this.comprehension = comprehension;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
