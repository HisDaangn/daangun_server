package com.daangun.clonecode.controller;

import com.daangun.clonecode.model.Request.UserRequest;
import com.daangun.clonecode.model.User;
import com.daangun.clonecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserRequest userReq){
        User user = userService.saveUser(User.from(userReq));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){return userService.getAllUsers();}


    @GetMapping("/getUser/")




}
