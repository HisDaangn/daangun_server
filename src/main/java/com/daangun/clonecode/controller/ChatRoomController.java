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

import javax.persistence.EntityNotFoundException;
import javax.xml.ws.Response;
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


    public List<ChatRoom> findAllByPostId(Long postId){
        List<ChatRoom> response = chatRoomService.findALlByPostId(postId);
        return response;
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<ChatRoom>> findAllByUserId(@PathVariable Long id){
        List<ChatRoom> response = chatRoomService.findAllByUserId(id);
        return ResponseEntity.ok(response);
    }


    // Response -> String roomId
    @PostMapping(value = "/add")
    public ResponseEntity<String> create(@RequestBody ChatRoomRequest request){
        List<ChatRoom> temp = this.findAllByPostId(request.getPostId());
        if(temp.size()>0){
            for(int i=0; i<temp.size();i++){
                if(temp.get(i).getPubId().equals(request.getPubId()) && temp.get(i).getSubId().equals(request.getSubId())){
                    try {
                        if(!temp.get(i).getPost().isDeleted()){
                            return ResponseEntity.ok(temp.get(i).getRoomId());
                        }
                    }
                    catch(EntityNotFoundException e){
                        return ResponseEntity.ok("deleted");
                    }
                }
            }
        }
        Post post =  postService.findOne(request.getPostId());
        if(post.isDeleted()) return ResponseEntity.ok("deleted");
        User sub = userService.findById(request.getSubId());
        User pub = userService.findById(request.getPubId());
        ChatRoom chatroom = ChatRoom.from(sub.getName(), pub.getName(), post, request);
        chatRoomService.save(chatroom);
        return ResponseEntity.ok(chatroom.getRoomId());

    }

    @GetMapping(value = "/room/{roomId}")
    public ResponseEntity<ChatRoom> findByRoomId(@PathVariable String roomId){
        ChatRoom response = chatRoomService.findByRoomId(roomId);
        return ResponseEntity.ok(response);
    }


    @GetMapping(value = "/count/{userid}")
    public ResponseEntity<Integer> countChatRoomByPostId(@PathVariable Long userid) {
        Integer response = chatRoomService.countChatRoomByPostId(userid);
        return ResponseEntity.ok(response);
    }

}
