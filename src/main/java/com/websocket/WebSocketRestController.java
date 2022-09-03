package com.websocket;

import com.websocket.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketRestController {

    private final WebSocketService webSocketService;

    @Autowired
    public WebSocketRestController(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody MessageDTO messageDTO) {
        webSocketService.notifyFrontend(messageDTO.getMessageContent());
    }
}
