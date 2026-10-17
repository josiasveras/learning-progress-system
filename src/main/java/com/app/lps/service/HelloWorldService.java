package com.app.lps.service;

import com.app.lps.dto.HelloWorldResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public HelloWorldResponse getHelloWorld() {

        return new HelloWorldResponse("Olá Mundo!");
    }
}
