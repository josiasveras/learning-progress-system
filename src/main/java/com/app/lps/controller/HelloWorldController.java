package com.app.lps.controller;

import com.app.lps.dto.HelloWorldResponse;
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

    @GetMapping("/v1/helloworld")
    ResponseEntity<HelloWorldResponse> getHelloWorld() {
        return ResponseEntity.status(HttpStatus.OK).body(helloWorldService.getHelloWorld());
    }
}
