package com.app.lps.controller;

import com.app.lps.records.HelloWorldResponse;
import com.app.lps.service.HelloWorldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lps/api")
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/v1/helloworld/{id}")
    public ResponseEntity<HelloWorldResponse> getHelloWorldById(@PathVariable("id") Long id) {
        HelloWorldResponse helloWorldResponse = helloWorldService.getHelloWorldById(id);
        return ResponseEntity.status(HttpStatus.OK).body(helloWorldResponse);
    }
}
