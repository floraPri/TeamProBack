package com.np.wearound;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/send/message")
    @SendTo("/topic/receive/message")
    public String handleReceivedMessage(String message) {
        // 여기에서 message를 처리
        System.out.println("Received Message: " + message);
        return message;
    }
}