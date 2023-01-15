package com.daangun.clonecode.controller;

import com.daangun.clonecode.model.Post;
import com.daangun.clonecode.model.Request.PostRequest;
import com.daangun.clonecode.model.User;
import com.daangun.clonecode.service.PostService;
import com.daangun.clonecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.xml.ws.Response;

@RestController
@RequestMapping("/trade")
@CrossOrigin
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Long> create(@RequestBody PostRequest request){
        User writer = userService.findById(request.getWriterId());
        Long id = postService.create(Post.from(writer, request));
        return ResponseEntity.ok(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody PostRequest request){
        Post target = postService.update(id, request);
        return ResponseEntity.ok(target);
    }





}
