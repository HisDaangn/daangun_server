package com.daangun.clonecode.controller;


import com.daangun.clonecode.model.ChatRoom;
import com.daangun.clonecode.model.Post;
import com.daangun.clonecode.model.Request.ChatRoomRequest;
import com.daangun.clonecode.service.ChatRoomService;
import com.daangun.clonecode.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chat")
@CrossOrigin
@Log4j2
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    private PostService postService;

    @GetMapping(value = "/room")
    public ResponseEntity<List<ChatRoom>> findAll(@RequestBody Long userId){
        List<ChatRoom> response = chatRoomService.findAllByUserId(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/room")
    public void create(@RequestBody ChatRoomRequest request){
        Post post =  postService.findById(request.getPostId());
        ChatRoom chatroom = ChatRoom.from(post, request);
        chatRoomService.save(chatroom);
    }

    @GetMapping(value = "/room/{id}")
    public ResponseEntity<ChatRoom> findAll(@PathVariable String roomId){
        ChatRoom response = chatRoomService.findByRoomId(roomId);
        return ResponseEntity.ok(response);
    }








}
