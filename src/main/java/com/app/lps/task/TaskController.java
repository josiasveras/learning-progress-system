package com.app.lps.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/v1/tasks/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        TaskResponse taskResponse = taskService.getTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

    @PostMapping("/v1/tasks")
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest) {
        TaskResponse taskResponse = taskService.createTask(taskRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(taskResponse.id())
                .toUri();
        return ResponseEntity.created(uri).body(taskResponse);
    }

    @DeleteMapping("/v1/tasks/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
