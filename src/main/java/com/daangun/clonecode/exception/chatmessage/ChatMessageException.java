package com.daangun.clonecode.exception.chatmessage;

import com.daangun.clonecode.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class ChatMessageException extends GlobalException {
    protected ChatMessageException(String message, HttpStatus httpStatus){
        super(message, httpStatus);
    }
}
