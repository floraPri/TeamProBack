package com.np.wearound;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.np.wearound.auctionDto.MessageDTO;

@Controller
public class WebSocketController {

    @MessageMapping("/send/message/{auctionno}")
    @SendTo("/topic/receive/message/{auctionno}")
    public MessageDTO handleReceivedMessage(@DestinationVariable String auctionno, @Payload MessageDTO message) {

        return message;
    }
    
    @MessageMapping("/send/HoGeMessage/{auctionno}")
    @SendTo("/topic/receive/HoGeMessage/{auctionno}")
    public MessageDTO handleRecivedHostGuestMessage (@DestinationVariable String auctionno, @Payload MessageDTO message) {
        
    	return message;
    }
    
}