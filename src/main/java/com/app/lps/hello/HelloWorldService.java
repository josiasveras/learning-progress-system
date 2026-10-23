package com.app.lps.hello;

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
