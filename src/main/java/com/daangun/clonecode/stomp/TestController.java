package com.daangun.clonecode.stomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private SimpMessagingTemplate webSocket;

    @MessageMapping("/sendTo")
    @SendTo("/topics/sendTo")
    public String SentToMessage() throws Exception{
        return "SendTo";
    }

    @MessageMapping("/Template")
    public void SendTemplateMessage() {
        webSocket.convertAndSend("/topics/template" , "Template");
    }

    @RequestMapping(value="/api")
    public void SendAPI() {
        webSocket.convertAndSend("/topics/api" , "API");
    }




}
