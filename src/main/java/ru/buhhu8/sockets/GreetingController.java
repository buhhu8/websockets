package ru.buhhu8.sockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/chat")
    @SendTo("/topic")
    public HelloMessage echo(HelloMessage mess) {
        return mess;
    }


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        for (int i = 0; i < 10; i++) {
            return new Greeting("Hello, " + i);
        }
        return new Greeting("Hello, " + message.getName());
    }

}
