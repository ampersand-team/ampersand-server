package com.ampersand.common.exception;

public class NotFoundException extends AmpersandException {
    public NotFoundException() {
        super(CommonErrorCode.NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(CommonErrorCode.NOT_FOUND, message);
    }

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public NotFoundException(String code, String message) {
        super(code, message);
    }

    public NotFoundException(Throwable throwable, ErrorCode errorCode) {
        super(throwable, errorCode);
    }

    public NotFoundException(Throwable throwable, ErrorCode errorCode, String message) {
        super(throwable, errorCode, message);
    }

    public NotFoundException(Throwable cause, String code, String message) {
        super(cause, code, message);
    }
}
