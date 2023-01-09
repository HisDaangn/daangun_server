package com.daangun.clonecode.service;

import com.daangun.clonecode.model.ChatMessage;

public interface ChatMessageService {
    public ChatMessage savePrivateMessage(ChatMessage message);
}
