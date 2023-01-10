package com.daangun.clonecode.exception.chatroom;

import com.daangun.clonecode.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class ChatRoomException extends GlobalException {
    protected ChatRoomException(String message, HttpStatus httpStatus){
        super(message, httpStatus);
    }
}
