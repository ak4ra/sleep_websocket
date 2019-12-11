package io.springak4ra.sleep_websocket.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.http.HttpStatus;

public class HTTPGetEvent extends ApplicationEvent {

    private HttpStatus httpStatusCode;
    private String url;

    public HTTPGetEvent(Object source, HttpStatus httpStatusCode, String url) {
        super(source);
        this.httpStatusCode = httpStatusCode;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }
}
