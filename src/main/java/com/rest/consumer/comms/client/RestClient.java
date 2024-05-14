package com.rest.consumer.comms.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class RestClient {

    private final WebClient webClient = WebClient.create("http://localhost:8080");

    public Mono<String> runGet(String endpoint){

        return webClient.get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> runPost(String endpoint, String message){

        return webClient.post()
                .uri(endpoint)
                .bodyValue(message)
                .retrieve()
                .bodyToMono(String.class);
    }
}
