package com.app.lps.goal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
