package com.daangun.clonecode.service;

import com.daangun.clonecode.model.ChatMessage;

import java.util.List;

public interface ChatMessageService {
    public ChatMessage save(ChatMessage message);
    public List<ChatMessage> findChatMessageByRoomId(String roomId);
}
