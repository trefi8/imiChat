package com.imi.chat.controller;

import com.imi.chat.model.dto.ChatMessage;
import com.imi.chat.model.common.MessageType;
import com.imi.chat.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    private ChatService chatService;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("User Disconnected : " + username);

            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setType(MessageType.LEAVE);
            chatMessage.setSender(username);

            StringBuilder b = new StringBuilder();
            chatService.getMessagesBySender(username).forEach(b::append);

            logger.info(b.toString());
            messagingTemplate.convertAndSend("/topic/javainuse", chatMessage);
        }
    }
}
