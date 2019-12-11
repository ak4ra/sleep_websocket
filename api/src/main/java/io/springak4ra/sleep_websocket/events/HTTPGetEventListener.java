package io.springak4ra.sleep_websocket.events;

import io.springak4ra.sleep_websocket.websockets.CustomWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HTTPGetEventListener {

    private CustomWebSocketHandler customWebSocketHandler;

    @Autowired
    public HTTPGetEventListener(CustomWebSocketHandler customWebSocketHandler) {
        this.customWebSocketHandler = customWebSocketHandler;
    }

    @EventListener
    public void onApplicationEvent(HTTPGetEvent event) {

        customWebSocketHandler.sendWebSocketMessage(event.getHttpStatusCode(), event.getUrl());
    }
}
