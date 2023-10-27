package com.np.wearound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.np.wearound.auctionDto.MessageDTO;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/send/message/{auctionno}")
    @SendTo("/topic/receive/message/{auctionno}")
    public MessageDTO handleReceivedMessage(@DestinationVariable String auctionno, @Payload MessageDTO message) {
        String topic = "/topic/receive/message/" + auctionno;
        // 여기에서 message를 처리
        System.out.println("메세지 수신: " + message);
        messagingTemplate.convertAndSend(topic, message);
        return message;
    }
    
    
    @MessageMapping("/send/HoGeMessage/{auctionno}")
    @SendTo("/topic/receive/HoGeMessage/{auctionno}")
    public MessageDTO handleRecivedHostGuestMessage (@DestinationVariable String auctionno, @Payload MessageDTO message) {
    	String topic = "/topic/receive/HoGeMessage/" + auctionno;
    	
        System.out.println("메세지 수신: " + message);
        messagingTemplate.convertAndSend(topic, message);
        
    	return message;
    }
    
}