package com.myPark.myPark.exception;

public enum ErrorCode {

    ADMIN_NOT_FOUND_EXCEPTION(1000),
    ADMIN_INVALID_EXCEPTION(1001),
    ADMIN_AUTHENTICATION_EXCEPTION(1002),
    CLIENT_NOT_FOUND_EXCEPTION(2000),
    CLIENT_AUTH(2001),
    ;

    private int code;
    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
