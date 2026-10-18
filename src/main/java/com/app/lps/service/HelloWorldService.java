package com.app.lps.service;

import com.app.lps.dto.HelloWorldResponse;
import com.app.lps.model.HelloWorld;
import com.app.lps.repository.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloWorldService {

    private final HelloWorldRepository helloWorldRepository;

    public HelloWorldService(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    public HelloWorld getHelloWorldById(Long id) {
        Optional<HelloWorld> helloWorldResponse = helloWorldRepository.findById(id);
      return helloWorldResponse.orElse(null);
    }
}
