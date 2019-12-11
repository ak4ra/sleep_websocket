package io.springak4ra.sleep_websocket.websockets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class CustomWebSocketHandler implements WebSocketHandler {

    private static Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) {
        log.error("error occurred at sender " + session, throwable);
    }

    public void sendWebSocketMessage(HttpStatus message, String url) {

        sessions.forEach((key, value) -> {
            try {
                value.sendMessage(new TextMessage(String.format("%s %s", message.toString(), url)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {

        log.info(String.format("new socket connection: %s", session.toString()));
        sessions.put(session.getId(), session);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        log.info(String.format("session %s closed because of %s", session.getId(), status.getReason()));
        sessions.remove(session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
