package com.guidob.basket.rest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.guidob.basket.basket.dto.DataPlayerDTO;

import reactor.core.publisher.Mono;



import java.util.Map;

@Component
public class ApiPlayerPhoto extends Api{
	
    @Value("${api.urlPlayerPhoto}")
    private String urlPlayerPhoto;
    
    public void setApi(String user_agent) {
    	
        this.webClient = WebClient
                .builder()
                .baseUrl(this.urlPlayerPhoto)
                .defaultHeader("Content-Type", "application/json")
                //.defaultHeader("Authentication", "bearer " + this.access_token)
                .defaultHeader("X-Total-Count","")
                .filter(logRequest())
                .filter(ExchangeFilterFunction.ofResponseProcessor(this::renderApiErrorResponse))
                .build();
                
    }

    //Dispara excepcion si response es 4xx/5xx al llamar a API
    private Mono<ClientResponse> renderApiErrorResponse(ClientResponse clientResponse) {
        if(clientResponse.statusCode().isError()){
            return clientResponse.bodyToMono(String.class)
                    .flatMap(apiErrorResponse -> Mono.error(new ResponseStatusException(
                            clientResponse.statusCode(),
                            apiErrorResponse
                    )));
        }
        return Mono.just(clientResponse);
    }
    
    public DataPlayerDTO getDataPlayer() {
        return this.call(HttpMethod.GET,
               "/player",
                Map.of(),
                Map.of())
                .bodyToMono(DataPlayerDTO.class)
                .block();
    }    
 

}
