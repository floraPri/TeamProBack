package com.np.wearound;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.np.wearound.auctionDto.MessageDTO;

@Controller
public class WebSocketController {

    // 프론트의 stompClient send 설정과 맞아야함 SendTosms 프론트 토픽 설정과 맞아야함
    // @DestinationVariable 은 auctionno을 추출하기 위해 사용함
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