package ru.buhhu8.sockets;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

import static java.lang.Thread.sleep;

@Component
public class HelloMessage extends AbstractWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {

        String payload = message.getPayload();
        JSONObject jsonObject = new JSONObject(payload);
        if(jsonObject.get("name").equals("Den")){
            session.sendMessage(new TextMessage("Hi Den"));
        }
        if(jsonObject.get("name").equals("Katya")){
            session.sendMessage(new TextMessage("hi Katya"));
        }
        session.sendMessage(new TextMessage("not authorized"));

    }

    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
