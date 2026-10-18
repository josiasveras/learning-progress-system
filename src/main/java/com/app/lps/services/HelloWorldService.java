package com.app.lps.services;

import com.app.lps.models.HelloWorld;
import com.app.lps.records.HelloWorldResponse;
import com.app.lps.repositories.HelloWorldRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloWorldService {

    private final HelloWorldRepository helloWorldRepository;

    public HelloWorldService(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    public HelloWorldResponse getHelloWorldById(Long id) {
        Optional<HelloWorld> helloWorldOptional = helloWorldRepository.findById(id);
        return helloWorldOptional.map(helloWorld -> new HelloWorldResponse(helloWorld.getContent())).orElse(null);
    }
}
