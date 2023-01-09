package com.daangun.clonecode.controller;

import com.daangun.clonecode.model.ChatRoom;
import com.daangun.clonecode.service.ChatMessageService;
import com.daangun.clonecode.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @Autowired
    private ChatMessageService chatMessageService;

//    @GetMapping("room/user/{roomId}")
//    public ResponseEntity<List<ChatRoom>> getChatRoom(@PathVariable Long roomId, @RequestParam(required = false) Long lastMsgNo){
//        HttpStatus status = HttpStatus.ACCEPTED;
//        List<ChatRoom> ret = null;
//        try{
////            ret = chatRoomService.getChatRoomById()
//        }
//        catch (Exception e){
//
//        }
//        return new ResponseEntity<List<ChatRoom>>;
//    }




}
