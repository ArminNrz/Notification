package com.websocket;

import com.websocket.dto.MessageDTO;
import com.websocket.dto.ResponseMessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

    @MessageMapping("/token-received")
    @SendTo("/event/notificationData")
    public ResponseMessageDTO receivedToken(MessageDTO messageDTO) {
        // process token
        // get notification related to that user
        return new ResponseMessageDTO(HtmlUtils.htmlEscape("This is notification DTO"));
    }
}
