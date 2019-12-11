package io.springak4ra.sleep_websocket;

import io.springak4ra.sleep_websocket.events.HTTPGetEvent;
import io.springak4ra.sleep_websocket.websockets.CustomWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class HTTPGetService {

    private final RestTemplate restTemplate;
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    public HTTPGetService(RestTemplateBuilder restTemplateBuilder, ApplicationEventPublisher applicationEventPublisher) {

        this.restTemplate = restTemplateBuilder
                .setReadTimeout(Duration.ofSeconds(500))
                .build();
//        this.restTemplate.setErrorHandler(new ErrorHandler());
        this. applicationEventPublisher = applicationEventPublisher;
    }

    public HttpStatus getResponseInfo(String url) {
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);

        System.out.println("pinged " + url);

        // publish an event when the response arrives
        HTTPGetEvent httpGetEvent = new HTTPGetEvent(this, response.getStatusCode(), url);
        applicationEventPublisher.publishEvent(httpGetEvent);

        return response.getStatusCode();
    }
}
