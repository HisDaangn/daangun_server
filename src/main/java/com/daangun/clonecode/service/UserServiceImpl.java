package com.daangun.clonecode.service;


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

//    @Override
//    public User updateUser(Long userId, User user) {
//        User response = userRepository.update(userId,user);
//        return null;
//    }
}
