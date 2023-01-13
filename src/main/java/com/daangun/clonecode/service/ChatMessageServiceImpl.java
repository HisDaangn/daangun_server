package com.daangun.clonecode.service;


import com.daangun.clonecode.model.ChatMessage;
import com.daangun.clonecode.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChatMessageServiceImpl implements ChatMessageService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    private UserService userService;
    private ChatRoomService chatRoomService;


    public ChatMessage savePrivateMessage(ChatMessage message) {
        ChatMessage ret = chatMessageRepository.save(message);
        System.out.println("채팅저장완료.");
        return ret;
    }




}
