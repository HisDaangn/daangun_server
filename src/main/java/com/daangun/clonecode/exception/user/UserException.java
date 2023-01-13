package com.daangun.clonecode.exception.user;

import com.daangun.clonecode.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class UserException extends GlobalException {
    protected UserException(String message, HttpStatus httpStatus){
        super(message, httpStatus);
    }
}