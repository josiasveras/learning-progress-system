package com.app.lps.controllers;

import com.app.lps.records.TaskResponse;
import com.app.lps.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/lps/api")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/v1/tasks")
    public ResponseEntity<Stream<TaskResponse>> getTasks() {
        Stream<TaskResponse> taskResponse = taskService.getTasks();
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }
}
