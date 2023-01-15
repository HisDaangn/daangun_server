//
//package com.daangun.clonecode.controller;
//
//
//import com.daangun.clonecode.model.ChatMessage;
//import com.daangun.clonecode.model.Request.ChatMessageRequest;
//import com.daangun.clonecode.model.User;
//import com.daangun.clonecode.service.ChatMessageService;
//import com.daangun.clonecode.service.UserService;
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
////    private SimpMessagingTemplate messagingTemplate;
//    private ChatMessageService chatMessageService;
//    private UserService userService;
//
//    @MessageMapping("/chat/msg")
//    public void privateMessage(@RequestBody ChatMessageRequest request){
////        User writer = userService.findById(request.getWriterId());
//        ChatMessage msg = chatMessageService.save(ChatMessage.from(request));
////        messagingTemplate.convertAndSend("/sub/chat/room/"+ msg.getChatRoomId(), msg);
//    }
//
//}
//
