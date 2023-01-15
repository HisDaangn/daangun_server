package com.daangun.clonecode.service;

import com.daangun.clonecode.model.Request.UserRequest;
import com.daangun.clonecode.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User findById(Long userId);
    public User findUserByGoogleId(String googleId);
    public User update(String googleId, UserRequest userRequest);
}
