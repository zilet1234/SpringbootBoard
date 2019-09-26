package com.general.exception;

public class YoungException extends Exception {

    public YoungException(ExceptionCode exceptionCode){
        super(exceptionCode.getMessage());
    }

}
