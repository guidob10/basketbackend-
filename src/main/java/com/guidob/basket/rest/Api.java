package com.guidob.basket.rest;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class Api {

    protected WebClient webClient;

    public WebClient.ResponseSpec call(HttpMethod method, String path, Map<String, String> parametros, Map<String, String> body) {

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        if (!parametros.isEmpty()) {
            parametros.forEach((key, value) -> queryParams.add(key, value));
        }

        return this.webClient
                .method(method)
                .uri(uriBuilder -> uriBuilder
                        .path(path)
                .queryParams(queryParams)
                        .build())
                .body(BodyInserters.fromPublisher(Mono.just(body), Map.class))
                .retrieve();
    }

    public ClientResponse callWithHeaders(HttpMethod method, String path, Map<String, String> parametros, Map<String, String> body) {

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        if (!parametros.isEmpty()) {
            parametros.forEach((key, value) -> queryParams.add(key, value));
        }

        return this.webClient
                .method(method)
                .uri(uriBuilder -> uriBuilder
                        .path(path)
                        .queryParams(queryParams)
                        .build())
                .body(BodyInserters.fromPublisher(Mono.just(body), Map.class))
                .exchange()
                .block();
    }

    public WebClient.RequestHeadersSpec<?> callFlux(HttpMethod method, String path, Map<String, String> parametros, Map<String, String> body) {

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        if (!parametros.isEmpty()) {
            parametros.forEach((key, value) -> queryParams.add(key, value));
        }

        return this.webClient
                .method(method)
                .uri(uriBuilder -> uriBuilder
                        .path(path)
                        .queryParams(queryParams)
                        .build())
                .body(BodyInserters.fromPublisher(Mono.just(body), Map.class));
    }

    public WebClient.ResponseSpec call(HttpMethod method, String path, Map<String, String> parametros, Object body, Class classBody) {

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        if (!parametros.isEmpty()) {
            parametros.forEach((key, value) -> queryParams.add(key, value));
        }

        return this.webClient
                .method(method)
                .uri(uriBuilder -> uriBuilder
                        .path(path)
                        .queryParams(queryParams)
                        .build())
                .body(BodyInserters.fromPublisher(Mono.just(body), classBody))
                .retrieve();
    }

    private Mono<? extends Throwable> handleError(String message) {
      //  log.error(message);
        return Mono.error(Exception::new);
    }


    protected static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
        	System.out.println(clientRequest.url());  
            return Mono.just(clientRequest);
        });
    }
}

