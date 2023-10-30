package com.np.wearound;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocket
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	// 웹소켓 url 지정 topic 은 1/n queue는 1/1로 보통 사용함 프론트에 send 하기 위해 접속하는 첫번째 /app 으로 시작하게 됨 그리고 건네주기 위한 구독 경로 시작은 /topic 이나 /queue 으로 됨
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	System.out.println("웹소켓 브로커");
    	config.setApplicationDestinationPrefixes("/app")
        .enableSimpleBroker("/topic", "/queue");
    }

    // 웹소켓 url 지정 엔드포인트 프론트에서 SockJS 연결시 기본적으로 new SockJS에 url을 지정하는데 서버 주소 포트(백)/ws 이나 /auction/auctionDetail로 시작함. 
 	// setAllowedOriginPatterns 은 넘어오는 모든 요청에 대한 허용설정, .withSockJS()는 sockjs를 지원하지 않는 브라우저라도 지원할 수 있게 해준는 메서드다.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	System.out.println("엔드포인트 체크");
    	registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    	registry.addEndpoint("/auction/auctionDetail").setAllowedOriginPatterns("*").withSockJS();

    }
}