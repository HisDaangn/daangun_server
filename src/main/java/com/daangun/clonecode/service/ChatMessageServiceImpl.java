package com.daangun.clonecode.service;


import com.daangun.clonecode.model.ChatMessage;
import com.daangun.clonecode.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatMessageServiceImpl implements ChatMessageService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ChatRoomService chatRoomService;



    public ChatMessage save(ChatMessage message) {
        ChatMessage ret = chatMessageRepository.save(message);
        System.out.println("채팅저장완료.");
        return ret;
    }

    @Override
    public List<ChatMessage> findChatMessageByRoomId(String roomId) {
        List<ChatMessage> response = chatMessageRepository.findChatMessageByRoomId(roomId);
        return response;
    }
}
