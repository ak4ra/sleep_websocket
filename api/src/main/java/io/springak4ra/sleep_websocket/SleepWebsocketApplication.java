package io.springak4ra.sleep_websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SleepWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleepWebsocketApplication.class, args);
    }

}
