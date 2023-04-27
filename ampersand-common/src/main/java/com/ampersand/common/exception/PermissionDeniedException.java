package com.ampersand.common.exception;

public class PermissionDeniedException extends AmpersandException {
    public PermissionDeniedException() {
        super(CommonErrorCode.PERMISSION_DENIED);
    }

    public PermissionDeniedException(String message) {
        super(CommonErrorCode.PERMISSION_DENIED, message);
    }

    public PermissionDeniedException(ErrorCode errorCode) {
        super(errorCode);
    }

    public PermissionDeniedException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public PermissionDeniedException(String code, String message) {
        super(code, message);
    }

    public PermissionDeniedException(Throwable throwable, ErrorCode errorCode) {
        super(throwable, errorCode);
    }

    public PermissionDeniedException(Throwable throwable, ErrorCode errorCode, String message) {
        super(throwable, errorCode, message);
    }

    public PermissionDeniedException(Throwable cause, String code, String message) {
        super(cause, code, message);
    }
}
