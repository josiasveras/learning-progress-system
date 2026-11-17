package com.app.lps.goal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lps/api")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping("/v1/goals")
    public ResponseEntity<List<GoalResponse>> getGoals() {
        List<GoalResponse> goalResponses = goalService.getGoals();
        return ResponseEntity.status(HttpStatus.OK).body(goalResponses);
    }

    @GetMapping("/v1/goals/{id}")
    public ResponseEntity<GoalResponse> getGoalById(@PathVariable Long id) {
        GoalResponse goalResponse = goalService.getGoalById(id);
        return ResponseEntity.status(HttpStatus.OK).body(goalResponse);
    }

    @PostMapping("/v1/goals")
    public ResponseEntity<GoalResponse> createGoal(@RequestBody GoalRequest goalRequest) {
        GoalResponse goalResponse = goalService.createGoal(goalRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(goalResponse.id())
                .toUri();
        return ResponseEntity.created(uri).body(goalResponse);
    }

    @PutMapping("/v1/goals/{id}")
    public ResponseEntity<GoalResponse> updateGoalById(@PathVariable Long id, @RequestBody GoalRequest goalRequest) {
        GoalResponse goalResponse = goalService.updateGoalById(id, goalRequest);
        return ResponseEntity.ok(goalResponse);
    }
}
