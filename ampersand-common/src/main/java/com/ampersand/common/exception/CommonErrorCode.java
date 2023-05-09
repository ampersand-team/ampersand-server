package com.ampersand.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {
    PERMISSION_DENIED("PERMISSION_DENIED", "permission denied"),

    NOT_FOUND("NOT_FOUND", "not found"),

    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "system error");

    private final String code;

    private final String message;
}
