package com.daangun.clonecode.exception.post;

import com.daangun.clonecode.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class PostException extends GlobalException {
    public PostException(String message, HttpStatus httpStatus){
        super(message, httpStatus);
    }
}
