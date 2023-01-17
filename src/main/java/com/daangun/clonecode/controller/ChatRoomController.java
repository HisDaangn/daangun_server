package com.daangun.clonecode.controller;


import com.daangun.clonecode.model.ChatRoom;

import com.daangun.clonecode.model.Post;
import com.daangun.clonecode.model.Request.ChatRoomRequest;
import com.daangun.clonecode.model.User;
import com.daangun.clonecode.service.ChatRoomService;
import com.daangun.clonecode.service.PostService;
import com.daangun.clonecode.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/chat")
@CrossOrigin
@Log4j2
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;


    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<ChatRoom>> findAllByUserId(@PathVariable Long id){
        List<ChatRoom> response = chatRoomService.findAllByUserId(id);
        return ResponseEntity.ok(response);
    }


    // Response -> String roomId
    @PostMapping(value = "/add")
    public ResponseEntity<String> create(@RequestBody ChatRoomRequest request){
        if(chatRoomService.checkRoom(request.getPostId(), request.getPubId())){
            return ResponseEntity.ok(chatRoomService.findChatRoomByPostAndUser(request.getPostId(), request.getPubId()).getRoomId());
        }
        else{
            Post post =  postService.findOne(request.getPostId());
            User sub = userService.findById(request.getSubId());
            User pub = userService.findById(request.getPubId());
            ChatRoom chatroom = ChatRoom.from(sub.getName(), pub.getName(), post, request);
            chatRoomService.save(chatroom);
            return ResponseEntity.ok(chatroom.getRoomId());
        }
    }

    @GetMapping(value = "/room/{roomId}")
    public ResponseEntity<ChatRoom> findByRoomId(@PathVariable String roomId){
        ChatRoom response = chatRoomService.findByRoomId(roomId);
        return ResponseEntity.ok(response);
    }


    @GetMapping(value = "")
    public ResponseEntity<Integer> countChatRoomByPostId(@RequestBody Post post) {
        Integer response = chatRoomService.countChatRoomByPostId(post.getId());
        return ResponseEntity.ok(response);
    }

}
