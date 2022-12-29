package com.daangun.clonecode.service;

import com.daangun.clonecode.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
}
