package com.daangun.clonecode.controller;

import com.daangun.clonecode.model.ChatMessage;
import com.daangun.clonecode.model.Request.ChatMessageRequest;
import com.daangun.clonecode.model.User;
import com.daangun.clonecode.service.ChatMessageService;
import com.daangun.clonecode.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class STOMPController {

    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
    private ChatMessageService chatMessageService;


    //Client가 SEND할 수 있는 경로
    //stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    //"/pub/chat/enter"
//    @MessageMapping(value = "/chat/enter")
//    public void enter(@RequestBody ChatMessageRequest message){
//        User user = userService.findById(message.getWriterId());
//        message.setMessage(user.getName() + "님이 채팅방에 참여하였습니다.");
//        template.convertAndSend("/sub/chat/room/" + message.getChatRoomId(), message);
//    }

    @MessageMapping(value = "/chat/room/{roomId}")
    public void message(@PathVariable String roomId, @RequestBody ChatMessageRequest message){
        chatMessageService.save(ChatMessage.from(message));
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    // RoomId -> Message 전부 가져오는 API
    @GetMapping(value="/chat/message/{roomId}")
    public ResponseEntity<List<ChatMessage>> findAllByRoomId(@PathVariable String roomId){
        List<ChatMessage> response = chatMessageService.findChatMessageByRoomId(roomId);
        return ResponseEntity.ok(response);
    }


}
