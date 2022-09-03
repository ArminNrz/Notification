package com.websocket;

import com.websocket.dto.ResponseMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public WebSocketService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void notifyFrontend(final String message) {
        ResponseMessageDTO response = new ResponseMessageDTO(message);
        simpMessagingTemplate.convertAndSend("/event/notification", response);
    }
}
