package com.ampersand.common.exception;

public class InternalServerException extends AmpersandException {
    public InternalServerException() {
        super(CommonErrorCode.INTERNAL_SERVER_ERROR);
    }

    public InternalServerException(String message) {
        super(CommonErrorCode.INTERNAL_SERVER_ERROR, message);
    }

    public InternalServerException(ErrorCode errorCode) {
        super(errorCode);
    }

    public InternalServerException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public InternalServerException(String code, String message) {
        super(code, message);
    }

    public InternalServerException(Throwable throwable, ErrorCode errorCode) {
        super(throwable, errorCode);
    }

    public InternalServerException(Throwable throwable, ErrorCode errorCode, String message) {
        super(throwable, errorCode, message);
    }

    public InternalServerException(Throwable cause, String code, String message) {
        super(cause, code, message);
    }
}
