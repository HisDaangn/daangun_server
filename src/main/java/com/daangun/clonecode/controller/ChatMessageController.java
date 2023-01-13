//package com.daangun.clonecode.controller;
//
//
//import com.daangun.clonecode.model.ChatMessage;
//import com.daangun.clonecode.model.Request.ChatMessageRequest;
//import com.daangun.clonecode.service.ChatMessageService;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin
//public class ChatMessageController {
//    private SimpMessagingTemplate messagingTemplate;
//    private ChatMessageService chatMessageService;
//
//    @MessageMapping("/chat/msg")
//    public void privateMessage(@RequestBody ChatMessageRequest request){
//        ChatMessage msg = chatMessageService.savePrivateMessage(ChatMessage.from(request));
//        messagingTemplate.convertAndSend("/sub/chat/room/"+ msg.getChatRoomId(), msg);
//    }
//
//}
