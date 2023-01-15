package com.daangun.clonecode.service;


import com.daangun.clonecode.model.Request.UserRequest;
import com.daangun.clonecode.model.User;
import com.daangun.clonecode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) {
        User response = userRepository.findById(userId).get();
        return response;
    }

    @Override
    public User findUserByGoogleId(String googleId) {
        User response = userRepository.findUserByGoogleId(googleId);
        return response;
    }

    @Override
    public User update(String googleId, UserRequest userRequest) {
        User user = this.findUserByGoogleId(googleId);
        user.update(userRequest);
        return user;
    }
}
