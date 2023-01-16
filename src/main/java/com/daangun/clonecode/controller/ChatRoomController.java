package com.daangun.clonecode.controller;


import com.daangun.clonecode.model.ChatRoom;

import com.daangun.clonecode.model.Post;
import com.daangun.clonecode.model.Request.ChatRoomRequest;
import com.daangun.clonecode.model.User;
import com.daangun.clonecode.service.ChatRoomService;
import com.daangun.clonecode.service.PostService;
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

    // 채팅 들어갔을 때 유저 채팅방 모두 불러오기
    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<ChatRoom>> findAllByUserId(@PathVariable Long id){
        List<ChatRoom> response = chatRoomService.findAllByUserId(id);
        return ResponseEntity.ok(response);
    }

    // response -> string roomid
    // 물품에서 채팅하기 누르면 저거
    @PostMapping(value = "/add")
    public ResponseEntity<String> create(@RequestBody ChatRoomRequest request){
        Post post =  postService.findOne(request.getPostId());
        ChatRoom chatroom = ChatRoom.from(post, request);
        chatRoomService.save(chatroom);
        return ResponseEntity.ok(chatroom.getRoomId());
    }

    // return되는 roomid로 url에 붙히면 새로 생성된 채팅룸이 뜨도록 한다.


    @GetMapping(value = "/room/{roomId}")
    public ResponseEntity<ChatRoom> findByRoomId(@PathVariable String roomId){
        ChatRoom response = chatRoomService.findByRoomId(roomId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Integer> countChatRoomByPostId(@PathVariable Long id) {
        Integer response = chatRoomService.countChatRoomByPostId(id);
        return ResponseEntity.ok(response);
    }

}
