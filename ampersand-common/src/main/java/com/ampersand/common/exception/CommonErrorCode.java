package com.ampersand.common.exception;

public enum CommonErrorCode implements ErrorCode {
    PERMISSION_DENIED("PERMISSION_DENIED", "permission denied"),

    NOT_FOUND("NOT_FOUND", "not found"),

    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "system error");

    private final String code;

    private final String message;

    CommonErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
