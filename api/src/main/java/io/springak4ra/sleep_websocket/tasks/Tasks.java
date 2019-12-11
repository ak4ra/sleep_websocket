package io.springak4ra.sleep_websocket.tasks;

import io.springak4ra.sleep_websocket.HTTPGetService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Tasks {

    private HTTPGetService httpGetService;

    public Tasks(HTTPGetService httpGetService) {
        this.httpGetService = httpGetService;
    }

     @Scheduled(cron = "*/10 * * * * *")
     public void sendGetRequest1() {

     httpGetService.getResponseInfo("https://morning-castle-644884.herokuapp.com/");
     }

    @Scheduled(cron = "*/10 * * * * *")
    public void sendGetRequest2() {

        httpGetService.getResponseInfo("http://167.71.3.20/");
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void sendGetRequest3() {

        httpGetService.getResponseInfo("https://dreadful-catacombs-63500.herokuapp.com/");
    }
}
