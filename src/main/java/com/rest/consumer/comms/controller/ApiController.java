package com.rest.consumer.comms.controller;

import com.rest.consumer.comms.client.RestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final RestClient client;

    @GetMapping("/hello")
    public Mono<String> getHello(){
        return client.runGet("/api/hello");
    }
    @PostMapping("/echo")
    public Mono<String> postMessage(){
        return client.runPost("/api/echo", "test message");
    }
}
