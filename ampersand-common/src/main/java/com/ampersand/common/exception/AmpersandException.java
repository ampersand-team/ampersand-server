package com.ampersand.common.exception;

import lombok.Getter;

@Getter
public class AmpersandException extends RuntimeException {
    private final String code;

    private final String message;

    public AmpersandException(ErrorCode errorCode) {
        this(errorCode.code(), errorCode.message());
    }

    public AmpersandException(ErrorCode errorCode, String message) {
        this(errorCode.code(), message);
    }

    public AmpersandException(String code, String message) {
        this(null, code, message);
    }

    public AmpersandException(Throwable throwable, ErrorCode errorCode) {
        this(throwable, errorCode.code(), errorCode.message());
    }

    public AmpersandException(Throwable throwable, ErrorCode errorCode, String message) {
        this(throwable, errorCode.code(), message);
    }

    public AmpersandException(Throwable cause, String code, String message) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
}
