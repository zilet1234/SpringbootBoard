package com.general.exception;

public enum  ExceptionCode {

    NULL("Null 오류입니다."),
    NOTDIRECTORY("디렉토리가 존재하지 않습니다."),
    NOTFILE("파일이 존재하지 않습니다.");

    private String message;
    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
